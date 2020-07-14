package com.zrx.fragment.nio;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description
 * 阻塞式NIO
 * <p>
 * 通道
 * SelectableChannel
 * <p>
 * 缓存区
 * <p>
 * 选择器
 *
 * <p>
 * Data
 * 2020/7/13-19:25
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-13 19:25")
public class 阻塞式NIO {
    private final static Logger LOGGER = LoggerFactory.getLogger(阻塞式NIO.class);

    private Selector selector;

    private SelectableChannel selectableChannel;

    private SocketChannel socketChannel;

    private ServerSocketChannel serverSocketChannel;

    private DatagramChannel datagramChannel;

    private Pipe.SinkChannel sinkChannel;

    private Pipe.SourceChannel sourceChannel;

    private Charset c = Charset.forName("utf-8");

    @Invoking(createdTime = "2020-07-13 19:37")
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
                this.client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        pool.shutdown();

        pool.awaitTermination(500, TimeUnit.MICROSECONDS);
    }

    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        byte[] data = new byte[1024];

        int len;
        while ((len = socketChannel.read(byteBuffer)) != -1) {
            LOGGER.info("len = {}", len);
            byteBuffer.flip();
            byteBuffer.get(data, 0, len);
            String s = new String(data, 0, len);
            LOGGER.info("s = {}", s);
            byteBuffer.clear();
        }

        socketChannel.close();
    }

    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(9898));

        SocketChannel socketChannel = serverSocketChannel.accept();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        byteBuffer.put("abcdef".getBytes());

        byteBuffer.flip();

        socketChannel.write(byteBuffer);

        socketChannel.close();

        serverSocketChannel.close();
    }
}
