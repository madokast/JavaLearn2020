package com.zrx.ichiwanspringboot.mapper;

import com.zrx.ichiwanspringboot.bean.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogFile;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description
 * EntryMapperTest
 * <p>
 * Data
 * 22:59
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntryMapperTest {
    private final Logger LOGGER = LoggerFactory.getLogger(EntryMapperTest.class);

    @Autowired
    private EntryMapper entryMapper;

    @Test
    public void testFindAll(){
        entryMapper.findAll()
                .forEach(entry -> LOGGER.info("entry = {}", entry));
    }

}
