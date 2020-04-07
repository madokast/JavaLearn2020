package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.EntryItem;

import java.util.Date;
import java.util.List;

/**
 * 统计
 */

public interface StatisticsService {

    List<EntryItem> findEntryItemsAt(Date date);

    /**
     * 返回 date 日期所在天的总时长
     * @param date 日期
     * @return date 日期所在天的总时长
     */
    int totalLengthMinAt(Date date);



}
