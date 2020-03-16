package com.madokast.privacy.learn.config;

import com.madokast.privacy.learn.bean.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;
import java.util.Objects;

/**
 * Description
 * RedisConfig
 * 自己的redis模板
 * 在于将 Employee 存储为 json 字符串 格式
 * <p>
 * Data
 * 21:37
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class RedisConfig {

    private final static Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    /**
     * 让 redis 保存为 Json 数据
     * @param redisConnectionFactory ？
     * @return 一个redis template 类似于 jdbc template
     * @throws UnknownHostException ？
     */
    @Bean
    public RedisTemplate<String, Employee> employeeRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);

        template.setDefaultSerializer(serializer);


        LOGGER.info("注入employeeRedisTemplate");
        return template;
    }

    @Bean
    public RedisCacheManager employeeRedisCacheManager(RedisTemplate<String, Employee> employeeRedisTemplate){
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(
                Objects.requireNonNull(employeeRedisTemplate.getConnectionFactory()));
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(
                        employeeRedisTemplate.getValueSerializer()));

        LOGGER.info("注入employeeRedisCacheManager");
        return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
    }

}
