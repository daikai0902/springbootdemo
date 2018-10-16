package com.dk.multisource.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 在访问数据库时会调用该类的 determineCurrentLookupKey() 方法获取数据库实例的 key
 * @autor kevin.dai
 * @Date 2018/10/11
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {


    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    protected Object determineCurrentLookupKey() {
        String curDataSourceKey = DynamicDataSourceContextHolder.getDataSourceKey();
        logger.info("当前的数据源是："+curDataSourceKey);
        return curDataSourceKey;
    }
}
