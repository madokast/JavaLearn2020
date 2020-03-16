package com.madokast.privacy;

import com.madokast.privacy.learn.CacheLearn;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PrivacyApplicationTests {
    private final Logger LOGGER = LoggerFactory.getLogger(PrivacyApplicationTests.class);

    @Test
    public void test(){
        LOGGER.info("test");
    }
}
