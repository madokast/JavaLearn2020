package com.zrx.fragment.nio;

import com.zrx.Invoking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * Description
 * 缓冲区
 * <p>
 * Data
 * 2020/7/11-23:42
 *
 * @author zrx
 * @version 1.0
 */

@Invoking(createdTime = "2020-07-11 23:42")
public class BufferLearn {
    private final static Logger LOGGER = LoggerFactory.getLogger(BufferLearn.class);

    @Invoking(createdTime = "2020-07-13 09:05")
    public void 缓冲区学习() {
        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);

        // info
        printInfo(byteBuffer);

        // put
        byteBuffer.put("abc".getBytes());

        //info
        printInfo(byteBuffer); //buffer.position() = 3

        // flip
        byteBuffer.flip();
        printInfo(byteBuffer);
        //buffer.position() = 0
        //buffer.limit() = 3

        // get
        byte[] data = new byte[byteBuffer.limit()];
        byteBuffer.get(data);
        String s = new String(data);
        LOGGER.info("s = {}", s);
        printInfo(byteBuffer); //buffer.position() = 3


        //rewind
        byteBuffer.rewind();
        printInfo(byteBuffer); //buffer.position() = 0

//        byteBuffer.mark()

//        byteBuffer.reset()

    }

    private void printInfo(Buffer buffer) {
        LOGGER.info("buffer.capacity() = {}", buffer.capacity());
        LOGGER.info("buffer.limit() = {}", buffer.limit());
        LOGGER.info("buffer.position() = {}", buffer.position());
//        LOGGER.info("buffer.mark() = {}", buffer.mark());
    }
}
