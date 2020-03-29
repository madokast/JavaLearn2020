package com.zrx.ichiwanspringboot.service;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.bean.EntryPost;
import com.zrx.ichiwanspringboot.exception.ValidationFailedException;
import com.zrx.ichiwanspringboot.mapper.EntryMapper;
import com.zrx.ichiwanspringboot.utils.EntryUtil;
import com.zrx.ichiwanspringboot.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
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

    private final Validator<EntryItem> entryItemValidator;

    public EntryServiceImpl(EntryMapper entryMapper, Validator<EntryItem> entryItemValidator) {
        this.entryMapper = entryMapper;
        this.entryItemValidator = entryItemValidator;
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
                .filter(Predicate.not(EntryItem::getDeleteBool))
                .map(entry -> {
                    long currentDays = Math.round(((double) entry.getDateDone().getTime() - firstDate.getTime()) / EntryUtil.DAY) + 1L;
                    int currentTotalLength = totalLengthMin.addAndGet(entry.getLengthMinute());
                    double averageLengthMin = (double) currentTotalLength / (double) currentDays;
                    averageLengthMin = ((double) ((int) (averageLengthMin * 1000))) / 1000.0;

                    return new EntryPost(
                            entry.getId(),
                            simpleDateFormat.format(entry.getDateDone()),
                            entry.getName(),
                            entry.getDescribing(),
                            entry.getLengthMinute(),
                            EntryUtil.minuteToHHmm(currentTotalLength),
                            averageLengthMin
                    );
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = {RuntimeException.class, Error.class})
    public void insert(EntryItem entryItem) throws ValidationFailedException {
        entryItemValidator.validate(entryItem);
        entryMapper.insert(entryItem);
    }

    @Override
    public void deleteLastOne() {
        entryMapper.deleteLastOne();
    }
}
