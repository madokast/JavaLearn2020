package com.madokast.privacy.learn.service;

import com.madokast.privacy.learn.bean.Employee;
import com.madokast.privacy.learn.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Description
 * EmployeeService
 * <p>
 * Data
 * 17:02
 *
 * @author zrx
 * @version 1.0
 */

@Service
public class EmployeeCacheService {
    Logger LOGGER = LoggerFactory.getLogger(EmployeeCacheService.class);

    private final EmployeeMapper employeeMapper;

    public EmployeeCacheService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    /**
     * 学习 Cacheable
     * 属性：
     * cacheNames 缓存名字，缓存组件的名字
     * key 缓存数据时使用的key。默认是方法参数的值
     * keyGenerator key生成器 和key二选一
     * cacheManager 缓存管理器
     * condition 指定条件成立的时候在缓存
     * unless 条件成立 不缓存
     * sync 异步模式
     *
     * 当导入了 redis 的 starter 后，就会使用redis作为缓存
     *
     * cacheManager 传入自己的 employeeRedisCacheManager
     *
     * @param id id
     * @return Employee
     */
    @Cacheable(cacheNames = "employee", condition = "#id>0", unless = "#result==null",cacheManager = "employeeRedisCacheManager")
    public Employee getEmployeeById(Integer id) {
        LOGGER.info("数据库查询{}号员工", id);
        return employeeMapper.getEmployeeById(id);
    }

}
