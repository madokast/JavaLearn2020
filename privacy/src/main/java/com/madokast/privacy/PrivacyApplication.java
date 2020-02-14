package com.madokast.privacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Path;

@SpringBootApplication
public class PrivacyApplication {
    public static void main(String[] args) {
        NonSpring.writeRunningInfo();
        SpringApplication.run(PrivacyApplication.class, args);
    }
}
