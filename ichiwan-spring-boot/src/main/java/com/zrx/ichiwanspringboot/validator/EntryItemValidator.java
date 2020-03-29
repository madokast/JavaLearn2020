package com.zrx.ichiwanspringboot.validator;

import com.zrx.ichiwanspringboot.bean.EntryItem;
import com.zrx.ichiwanspringboot.exception.ValidationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Description
 * EntryItemValidator
 * <p>
 * Data
 * 2020/3/25-17:26
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class EntryItemValidator implements Validator<EntryItem> {
    private final static Logger LOGGER = LoggerFactory.getLogger(EntryItemValidator.class);

    public EntryItemValidator() {
        LOGGER.info("EntryItemValidator injected");
    }

    @Override
    public void validate(EntryItem entryItem) throws ValidationFailedException {
        //    private Date dateDone;
        //
        //    private String name;
        //
        //    private Integer lengthMinute;

        if (entryItem.getDateDone() == null)
            throw new ValidationFailedException("date-done empty");

        if (entryItem.getName() == null || entryItem.getName().length() == 0)
            throw new ValidationFailedException("name empty");

        if (entryItem.getLengthMinute() == null)
            throw new ValidationFailedException("length empty empty");

        if (entryItem.getLengthMinute() <= 0)
            throw new ValidationFailedException("length cannot be 0 or less than 0");
    }
}
