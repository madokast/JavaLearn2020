package com.ruoyi.wangyuan.Config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Description
 * TimeJsonSerializer
 * <p>
 * 将 int 类型的 时间戳（秒） 转为字符串形式的时间
 *
 * <p>
 * Data
 * 2020/7/24-21:39
 *
 * @author zrx
 * @version 1.0
 */

public class TimeJsonSerializer extends JsonSerializer<Integer> {
    private final static Logger LOGGER = LoggerFactory.getLogger(TimeJsonSerializer.class);

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void serialize(Integer time, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Date date = new Date();
        date.setTime(time * 1000L);

        String format = DATE_TIME_FORMATTER.format(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));

        jsonGenerator.writeString(format);
    }
}
