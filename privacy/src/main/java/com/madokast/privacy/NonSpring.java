package com.madokast.privacy;

import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.Date;

/**
 * Description
 * 非spring管辖类
 * <p>
 * Data
 * 20:35
 *
 * @author zrx
 * @version 1.0
 */

public class NonSpring {

    public static void writeRunningInfo(){
        FileSystemResource fileSystemResource = new FileSystemResource(Path.of("./running.zrx"));
        if (!fileSystemResource.exists()) {
            try {
                boolean newFile = fileSystemResource.getFile().createNewFile();
                if(!newFile){
                    throw new RuntimeException("创建运行文件失败");
                }
            }catch (Exception e){
                System.err.println("创建运行文件失败");
                e.printStackTrace();
                System.exit(-1);
            }
        }

        OutputStream outputStream = null;

        try {
            outputStream = fileSystemResource.getOutputStream();
        }catch (Exception e){
            System.err.println("获取运行文件OutputStream失败");
            e.printStackTrace();
            System.exit(-1);
        }

        try {
            outputStream.write(new String("privacy项目运行于 " + new Date()).getBytes());
            outputStream.flush();
        }catch (Exception e){
            System.err.println("写入运行文件失败");
            e.printStackTrace();
            System.exit(-1);
        }finally {
            try {
                outputStream.close();
            }catch (Exception e){
                System.err.println("关闭运行文件失败");
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
