package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.bean.EntryPost;
import com.zrx.ichiwanspringboot.exception.BadRequestParameterException;
import com.zrx.ichiwanspringboot.exception.ValidationFailedException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EntryService {

    List<EntryPost> findAll();

    /**
     * 分页查找
     *
     * @param number            数目
     * @param startingIncluding 开始项(已去除删除的项) 第一项是 1
     * @return 分页结果
     */
    List<EntryPost> find(int number, int startingIncluding);

    /**
     * 分页查找
     *
     * @param pageNumber 页数。第一页 为 1
     * @param number     每页显示数目。
     * @return 分页查找结果
     */
    default List<EntryPost> findByPage(int pageNumber, int number) {
        return find(number, (pageNumber - 1) * number + 1);
    }

    /**
     * 总页数
     *
     * @param numberPerPage 每页显示数目
     * @return 总页数
     */
    default Integer totalPageNumber(int numberPerPage) throws BadRequestParameterException {
        if(numberPerPage<=0)
            throw new BadRequestParameterException("number is less or equal to zero");
        int count = count();
        return count / numberPerPage + (count % numberPerPage == 0 ? 0 : 1);
    }

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

    void insert(EntryItem entryItem) throws ValidationFailedException;

    /**
     * 删除最后一项，用于手滑
     */
    void deleteLastOne();
}
