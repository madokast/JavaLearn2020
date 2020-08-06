package com.zrx.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

/**
 * 插件签名
 */
@Intercepts({
        /*
         * 拦截 StatementHandler 对象的 parameterize 方法，参数是 {Statement.class}
         */
        @Signature(type = StatementHandler.class, method = "parameterize", args = {Statement.class})
})
public class MyFirstInterceptor implements Interceptor {

    private final Log LOGGER = LogFactory.getLog(MyFirstInterceptor.class);

    /**
     * 拦截目标方法
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        LOGGER.debug("intercept(invocation)" + invocation.toString());
        Object[] args = invocation.getArgs();
        Object target = invocation.getTarget();
        Method method = invocation.getMethod();

        LOGGER.debug("args = {}" + Arrays.toString(args));
        LOGGER.debug("method = {}" + method);
        LOGGER.debug("target = {}" + target);


        Object ret = invocation.proceed();

        PreparedStatement ps = (PreparedStatement) args[0];
//        ps.setInt(1,4);

        LOGGER.debug("执行 invocation.proceed()" + ret);
        return ret;
    }

    /**
     * 包装目标对象
     */
    @Override
    public Object plugin(Object target) {
        LOGGER.debug("包装要代理对象" + target.toString());
        Object wrapped = Plugin.wrap(target, this);
        LOGGER.debug("wrapped = " + wrapped.toString());
        return wrapped;
    }

    @Override
    public void setProperties(Properties properties) {
        //setProperties 拿到配置信息{username=123456}
        LOGGER.debug("setProperties 拿到配置信息" + properties.toString());
    }
}
