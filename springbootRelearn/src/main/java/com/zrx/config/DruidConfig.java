package com.zrx.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description
 * DruidConfig 数据源配置类
 * <p>
 * Data
 * 22:22
 *
 * @author zrx
 * @version 1.0
 */

@Configuration
public class DruidConfig {
    //手动new出这个bean，就可以使用配置文件了
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //配置druid监控
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");
        initParameters.put("allow","localhost");
        initParameters.put("deny","192.168.2.254");

        bean.setInitParameters(initParameters);

        return bean;
    }

    //配置一个监控的filter
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");

        bean.setInitParameters(initParameters);
        bean.setUrlPatterns(Collections.singletonList("/*"));

        return bean;
    }


}
