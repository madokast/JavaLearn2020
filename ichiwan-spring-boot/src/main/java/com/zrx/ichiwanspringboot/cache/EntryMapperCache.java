package com.zrx.ichiwanspringboot.cache;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.mapper.EntryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 * 缓存层
 * 对 EntryMapper 的缓存
 * <p>
 * Data
 * 2020/5/5-11:13
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class EntryMapperCache implements EntryMapper {
    private final static Logger LOGGER = LoggerFactory.getLogger(EntryMapperCache.class);

    private final EntryMapper entryMapper;

    public EntryMapperCache(EntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    private List<EntryItem> findAllCache = null;

    @Override
    public List<EntryItem> findAll() {
        if (findAllCache == null)
            findAllCache = entryMapper.findAll();

        return findAllCache;
    }

    private final Map<Date, List<EntryItem>> findEntryItemsAtMap = new HashMap<>();

    @Override
    public List<EntryItem> findEntryItemsAt(Date date) {
        if (!findEntryItemsAtMap.containsKey(date)) {
            findEntryItemsAtMap.put(date, entryMapper.findEntryItemsAt(date));
        }

        return findEntryItemsAtMap.get(date);
    }

    private Date firstDateCache = null;

    @Override
    public Date firstDate() {
        if (firstDateCache == null)
            firstDateCache = entryMapper.firstDate();

        return firstDateCache;
    }

    @Override
    public void insert(EntryItem entryItem) {
        findAllCache = null;
        findEntryItemsAtMap.clear();
        entryMapper.insert(entryItem);
        LOGGER.info("插入{}成功", entryItem);
    }

    @Override
    public void deleteLastOne() {
        findAllCache = null;
        findEntryItemsAtMap.clear();
        entryMapper.deleteLastOne();
        LOGGER.info("Entries表删除最后一项，成功");
    }

    @Override
    public int totalDate() {
        return entryMapper.totalDate();
    }
}
