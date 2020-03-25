package com.zrx.io.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Description
 * WebSocketServerController
 * <p>
 * web socket 技术 学习
 * <p>
 * 1. web socket 协议
 * -- H5 协议，实现 浏览器 和 服务器 全双工通信，由单个TCP实现
 * -- 可以双方同时发信
 * -- 基础知识：半双工，指的是同时只有一方能发信，如对讲机
 * -- 基础知识：全双工，可同时发信，如车辆对开
 * <p>
 * -- 推拉技术
 * -- 推送：服务器主动发信
 * -- 拉取：客户机主动请求信息
 * <p>
 * -- 优势：以前需要使用 HTTP轮询 和 TCP长链接 实现
 * -- 因为以前的 HTTP 是 <strong>无状态的</strong>。效率低下
 * <p>
 * -- websocket 是一种长链接，一次请求，然后通信都在这个 TCP 上进行
 * -- 原理图
 * -- 第一步：进行 opening handshake 打开握手
 * -- -- 客户端 发送 handshake request
 * -- -- 服务器 返回 handshake response
 * -- 第二步：双方通过 data frame 通信
 * -- 第三步：进行 closing handshake
 * -- -- 客户端 发送 closing handshake request 关闭握手
 * -- -- 服务器 发送 closing handshake response
 * <p>
 * -- 打开 和 关闭 都是 客户端 主动进行的？
 * -- 答： 分手 双方都可以
 * <p>
 * -- ⭐ 打开 和 关闭 的协议是基于 HTTP 的，发送的是 HTTP 格式的消息
 * -- upgrade: websocket 表示 请求 websocket
 * -- 具体报文略
 *
 * 2. 对比
 * -- H5 和 websocket -- -- websocket 是 H5 的一部分
 * -- socket 和 websocket -- -- socket 是为了更方便的使用底层 TCP/UDP 协议，而提供的抽象。websocket 是一套标准
 * -- websocket 中 建立/关闭 是基于HTTP协议的请求相应机制（底层还是socket）
 * -- websocket 中 通信 是基于 socket 的
 * -- socket 更灵活。 websocket 更方便
 *
 * 3. 客户端不支持 websocket 怎么办？
 * -- 答：可以用 JS 模拟，有一个叫 SockJS 的东西
 *
 * 4. 服务器 使用 websocket，tomcat 7+ 以上版本
 *
 * 5. 代码解释
 *
 *
 * <p>
 * Data
 * 2020/3/18-23:05
 *
 * @author zrx
 * @version 1.0
 */

@Component
@ServerEndpoint("/{user}")
public class WebSocket {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebSocket.class);

    private String user;
    private Session session;

    private final static Set<WebSocket> SOCKET_SET = new CopyOnWriteArraySet<>();

//    @Scheduled(cron = "0-59 * * * * *") //每秒执行
    public static void checkSet(){
        LOGGER.info("SOCKET_SET = \n {}", SOCKET_SET);
    }

    // 收到消息调用的方法
    @OnMessage
    public void onMessage(String message) {
        LOGGER.info("用户[{}]发来消息[{}]", user, message);

        SOCKET_SET.forEach(webSocket -> {
            try {
                webSocket.session.getBasicRemote().sendText(user+"发来消息：" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // 建立连接调用的方法
    @OnOpen
    public void onOpen(@PathParam("user") String user, Session session) {
        this.user = user;
        this.session = session;

        SOCKET_SET.stream().filter(webSocket -> webSocket.user.equals(user)).findAny().ifPresent(webSocket -> {
            LOGGER.info("同名用户{}建立连接，关闭前连接",user);
            SOCKET_SET.remove(webSocket);
            try {
                webSocket.session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        SOCKET_SET.add(this);
        LOGGER.info("用户[{}]建立连接", user);
    }

    // 关闭连接调用的方法
    @OnClose
    public void onClose(Session session) {
        SOCKET_SET.remove(this);
        LOGGER.info("用户[{}]的连接已关闭", user);
    }

    // 传输消息错误调用的方法
    @OnError
    public void OnError(Throwable error, Session session) throws IOException {
        LOGGER.info("用户[{}]发送错误，关闭连接", user);
        session.close();
    }

    @Override
    public String toString() {
        return "WebSocket{" +
                "user='" + user + '\'' +
                ", session=" + session +
                '}';
    }
}
