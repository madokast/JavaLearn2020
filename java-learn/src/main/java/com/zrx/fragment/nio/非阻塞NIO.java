package com.zrx.fragment.nio;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * 非阻塞NIO
 * <p>
 * Data
 * 2020/7/13-19:52
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-13 19:52")
public class 非阻塞NIO {
    private final static Logger LOGGER = LoggerFactory.getLogger(非阻塞NIO.class);


    //    @Invoking(createdTime = "2020-07-13 20:07")
    public void test() throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        pool.execute(() -> {
            try {
                this.server();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        TimeUnit.MICROSECONDS.sleep(500);

        pool.execute(() -> {
            try {
                this.client("123");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            try {
                this.client("321");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();

        pool.awaitTermination(500, TimeUnit.MICROSECONDS);
    }


    public void client(String info) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(
                new InetSocketAddress("127.0.0.1", 19897)
        );

        socketChannel.configureBlocking(false);

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        byteBuffer.put("info".getBytes());

        byteBuffer.flip();

        socketChannel.write(byteBuffer);

        socketChannel.close();
    }


    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);

        serverSocketChannel.bind(new InetSocketAddress(19897));

        Selector selector = Selector.open();

        // 监听事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // listen
        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {

                SelectableChannel channel = selectionKey.channel();

                if (selectionKey.isAcceptable()) {
                    channel.configureBlocking(false);

                    channel.register(selector, SelectionKey.OP_READ);
                } else {
                    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
                    int len = ((SocketChannel) channel).read(byteBuffer);
                    byteBuffer.flip();
                    String s = new String(byteBuffer.array(), 0, len);
                    LOGGER.info("s = {}", s);
                }
            }

            selectionKeys.clear();
        }
    }


}
