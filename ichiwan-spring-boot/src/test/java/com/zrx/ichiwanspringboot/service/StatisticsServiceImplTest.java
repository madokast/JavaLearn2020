package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Description
 * StatisticsServiceImplTest
 * <p>
 * Data
 * 2020/4/4-19:52
 *
 * @author zrx
 * @version 1.0
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsServiceImplTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceImplTest.class);

    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void test(){


        List<EntryItem> entryItemsAt = statisticsService.findEntryItemsAt(new Date());
        entryItemsAt.forEach(e-> LOGGER.info("e = {}", e));

        int i = statisticsService.totalLengthMinAt(new Date());
        LOGGER.info("i = {}", i);
    }
}
