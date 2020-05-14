package com.zrx.ichiwanspringboot.schedule;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.mail.MailWorker;
import com.zrx.ichiwanspringboot.mapper.EntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Description
 * 每日2次备份
 * <p>
 * Data
 * 2020/5/5-8:43
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class BackupSchedule {
    private final static Logger LOGGER = LoggerFactory.getLogger(BackupSchedule.class);

    private final EntryMapper entryMapper;

    private final MailWorker mailWorker;

    public BackupSchedule(EntryMapper entryMapper, MailWorker mailWorker) {
        this.entryMapper = entryMapper;
        this.mailWorker = mailWorker;
    }

    @Scheduled(cron = "0 0 6 * * ?")
    public void backupToMail() {
        LOGGER.info("数据备份到邮箱");

        String collect = entryMapper.findAll()
                .stream()
                .map(EntryItem::toMySqlInsertString)
                .collect(Collectors.joining("\n",
                        "-----------------------------------\n",
                        "\n-----------------------------------"));

        mailWorker.send("ICHIWAN back-up", collect);
    }
}
