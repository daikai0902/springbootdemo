package com.dk.multisource.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 该类为数据源上下文配置，用于切换数据源
 * @autor kevin.dai
 * @Date 2018/10/11
 */
public class DynamicDataSourceContextHolder {


    private  static final ThreadLocal<Object> contextHolder = new ThreadLocal<Object>(){
        @Override
        protected String initialValue() {
            return "master";
        }
    };


    /**
     * 数据源的 key 集合，用于切换时判断数据源是否存在
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();


    public static void setDataSourceKey(String dataSource){
        contextHolder.set(dataSource);
    }



    /**
     * @Description: 获取数据源类型
     */
    public static String getDataSourceKey() {
        return (String) contextHolder.get();
    }

    /**
     * @Description: 清除数据源类型
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }



    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

}
