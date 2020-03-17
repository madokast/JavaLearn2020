package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.Entry;
import com.zrx.ichiwanspringboot.bean.EntryPost;
import org.junit.Assert;
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
 * EntryServiceImplTest
 * <p>
 * Data
 * 0:05
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntryServiceImplTest {
    private final Logger LOGGER = LoggerFactory.getLogger(EntryServiceImplTest.class);

    @Autowired
    private EntryService entryService;

    @Test
    public void findTest(){
        int count = entryService.count();

        entryService
                .find(5,count-3)
                .stream()
                .map(EntryPost::toString)
                .forEach(LOGGER::info);
    }

    @Test
    public void projectLengthMinTest(){
        LOGGER.info("entryService.projectLengthMin() = {}", entryService.projectLengthMin());
    }

    @Test
    public void projectLengthMinTest02(){
        int sum = entryService.projectLengthMin().values().stream().mapToInt(Integer::valueOf).sum();
        int sum1 = entryService.findAll().stream().mapToInt(EntryPost::getLengthMin).sum();

        LOGGER.info("sum = {}", sum);
        LOGGER.info("sum1 = {}", sum1);

        Assert.assertEquals(sum1,sum);
    }

    @Test
    public void firstDateTest(){
        Date date = entryService.firstDate();
        LOGGER.info("date = {}", date);
    }

    @Test
    public void cacheTest(){
        Date date = entryService.firstDate();
        Date date2 = entryService.firstDate();
        Date date3 = entryService.firstDate();
        LOGGER.info("date3 = {}", date3);
        LOGGER.info("date2 = {}", date2);
        LOGGER.info("date = {}", date);

        List<EntryPost> all = entryService.findAll();
        List<EntryPost> all2 = entryService.findAll();
        List<EntryPost> all3 = entryService.findAll();
        LOGGER.info("all = {}", all.size());
        LOGGER.info("all2 = {}", all2.size());
        LOGGER.info("all3 = {}", all3.size());
    }

    @Test
    public void cacheTest02(){
        for (int i = 0; i < 10; i++) {
            int sum = entryService.projectLengthMin().values().stream().mapToInt(Integer::valueOf).sum();
            int sum1 = entryService.findAll().stream().mapToInt(EntryPost::getLengthMin).sum();

            LOGGER.info("sum = {}", sum);
            LOGGER.info("sum1 = {}", sum1);

            Assert.assertEquals(sum1,sum);
        }
    }

    @Test
    public void insertTest(){
        Entry entry = new Entry();
        entry.setName("Java");
        entry.setDateDone(new Date());
        entry.setDeleteBool(false);
        entry.setLengthMinute(30);
        entry.setDescribing("新写ichiwan");

//        entryService.insert(entry);
    }

    @Test
    public void deleteLastOneTest(){
        //entryService.deleteLastOne();
    }
}
