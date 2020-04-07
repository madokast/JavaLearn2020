package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.mapper.EntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description
 * StatisticsServiceImpl
 * <p>
 * Data
 * 2020/4/4-19:37
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(StatisticsServiceImpl.class);

    private final EntryMapper entryMapper;

    public StatisticsServiceImpl(EntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    @Override
    public List<EntryItem> findEntryItemsAt(Date date) {
        return entryMapper.findEntryItemsAt(date);
    }

    @Override
    public int totalLengthMinAt(Date date) {
        return findEntryItemsAt(date).stream().filter(e->!e.getDeleteBool()).mapToInt(EntryItem::getLengthMinute).sum();
    }
}
