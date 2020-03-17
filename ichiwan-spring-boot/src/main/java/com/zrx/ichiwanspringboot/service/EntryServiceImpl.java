package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.Entry;
import com.zrx.ichiwanspringboot.bean.EntryPost;
import com.zrx.ichiwanspringboot.mapper.EntryMapper;
import com.zrx.ichiwanspringboot.utils.EntryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * Description
 * EntryServiceImpl
 * <p>
 * Data
 * 23:17
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class EntryServiceImpl implements EntryService {

    private final Logger LOGGER = LoggerFactory.getLogger(EntryServiceImpl.class);

    private final ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private final EntryMapper entryMapper;

    public EntryServiceImpl(EntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    @Override
    public List<EntryPost> find(int number, int startingIncluding) {
        return findAll()
                .stream()
                .skip(startingIncluding - 1)
                .limit(number)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> projectLengthMin() {
        return findAll()
                .stream()
                .collect(Collectors.groupingBy(EntryPost::getProject))
                .values()
                .stream()
                .collect(Collectors.toMap(
                        list -> list.get(0).getProject(),
                        list -> list.stream().mapToInt(EntryPost::getLengthMin).sum()
                ));
    }

    @Override
    public int count() {
        return findAll().size();
    }


    @Override
    public Date firstDate() {
        return entryMapper.firstDate();
    }

    @Override
    public List<EntryPost> findAll() {
        AtomicInteger totalLengthMin = new AtomicInteger(0);
        Date firstDate = firstDate();
        SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();

        return entryMapper.findAll()
                .stream()
                .filter(Predicate.not(Entry::getDeleteBool))
                .map(entry -> {
                    long currentDays = Math.round(((double) entry.getDateDone().getTime() - firstDate.getTime()) / EntryUtils.DAY) + 1L;
                    int currentTotalLength = totalLengthMin.addAndGet(entry.getLengthMinute());
                    double averageLengthMin = (double) currentTotalLength / (double) currentDays;
                    averageLengthMin = ((double) ((int) (averageLengthMin * 1000))) / 1000.0;

                    return new EntryPost(
                            entry.getId(),
                            simpleDateFormat.format(entry.getDateDone()),
                            entry.getName(),
                            entry.getDescribing(),
                            entry.getLengthMinute(),
                            EntryUtils.minuteToHHmm(currentTotalLength),
                            averageLengthMin
                    );
                }).collect(Collectors.toList());
    }

    @Override
    public void insert(Entry entry) {
        entryMapper.insert(entry);
    }

    @Override
    public void deleteLastOne() {
        entryMapper.deleteLastOne();
    }
}
