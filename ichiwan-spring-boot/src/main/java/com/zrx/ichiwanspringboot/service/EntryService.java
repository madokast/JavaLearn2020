package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.Entry;
import com.zrx.ichiwanspringboot.bean.EntryPost;

import javax.swing.border.EmptyBorder;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EntryService {

    List<EntryPost> findAll();

    /**
     * 分页查找
     *
     * @param number            数目
     * @param startingIncluding 开始项(已去除删除的项)
     * @return 分页结果
     */
    List<EntryPost> find(int number, int startingIncluding);

    /**
     * 按照 project 统计的时长/min
     *
     * @return map
     */
    Map<String, Integer> projectLengthMin();


    /**
     * @return List<EntryPost>#size
     */
    int count();

    Date firstDate();

    void insert(Entry entry);

    /**
     * 删除最后一项，用于手滑
     */
    void deleteLastOne();
}
