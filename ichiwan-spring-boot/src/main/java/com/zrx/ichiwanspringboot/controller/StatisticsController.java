package com.zrx.ichiwanspringboot.controller;

import com.zrx.ichiwanspringboot.bean.DataWrapper;
import com.zrx.ichiwanspringboot.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description
 * StatisticsController
 * 统计相关
 * <p>
 * Data
 * 2020/4/4-19:33
 *
 * @author zrx
 * @version 1.0
 */

@CrossOrigin
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    private final static Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);

    private final StatisticsService statisticsServiceImpl;

    private final ThreadLocal<DateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(()->
            new SimpleDateFormat("yyyyMMdd"));

    public StatisticsController(StatisticsService statisticsServiceImpl) {
        this.statisticsServiceImpl = statisticsServiceImpl;
    }

    @GetMapping("/total/length/minute/at/date/{date}")
    public DataWrapper<Integer> totalLengthMinAt(@PathVariable String date) throws ParseException {

        Date parsed = dateFormatThreadLocal.get().parse(date);

        Integer totalLengthMinAt = statisticsServiceImpl.totalLengthMinAt(parsed);

        return DataWrapper.create("total length min at " + date ,totalLengthMinAt);
    }
}
