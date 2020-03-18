package com.zrx.demo.socket;

import com.zrx.demo.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * Description
 * WebSocketServerController
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


    // 收到消息调用的方法
    @OnMessage
    public void onMessage(String message) {
        LOGGER.info("用户{}发来消息[{}]", user, message);

        IntStream.range(0,100).forEach(i->{
            try {
                session.getBasicRemote().sendText("服务器消息：" + i);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ThreadUtils.sleep(100);
        });
    }

    // 建立连接调用的方法
    @OnOpen
    public void onOpen(@PathParam("user") String user, Session session) throws IOException {
        this.user = user;
        this.session=session;
        LOGGER.info("用户{}建立连接", user);
    }

    // 关闭连接调用的方法
    @OnClose
    public void onClose(Session session) {
        LOGGER.info("用户{}的连接已关闭", user);
    }

    // 传输消息错误调用的方法
    @OnError
    public void OnError(Throwable error, Session session) throws IOException {
        LOGGER.info("用户{}发送错误，关闭连接", user);
        session.close();
    }


}
