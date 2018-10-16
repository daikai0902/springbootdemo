package com.dk.multisource.annotation;

import com.dk.multisource.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @autor kevin.dai
 * @Date 2018/10/15
 */
@Aspect
@Component
public class DynamicDataSourceAspect {


    private final String[] TEST_PREFIX = {"test"};

    @Pointcut("execution(* com.dk.multisource.dao.*.*(..))")
    public void dataSourceAspect(){

    }


    private Boolean isTestMethod(String methodName) {
        for (String prefix : TEST_PREFIX) {
            if (methodName.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }


    @Before("dataSourceAspect())")
    public void switchDataSource(JoinPoint joinPoint){
        String m = joinPoint.getSignature().getName();
        if(isTestMethod(m)){
            DynamicDataSourceContextHolder.setDataSourceKey("test");
            System.err.println("当前使用的是:test数据源");
        }else{
            DynamicDataSourceContextHolder.setDataSourceKey("master");
            System.err.println("当前使用的是:master数据源");
        }
    }


    @After("dataSourceAspect())")
    public void restoreDataSource(JoinPoint point) {
        DynamicDataSourceContextHolder.clearDataSourceKey();
    }








}
