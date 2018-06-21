package com.baozi.aspect;

import com.baozi.util.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Copyright:   互融云
 * 统计controller管辖的各个方法耗时 便于以后优化
 * @author: zhangwenjun
 * @version: V1.0
 * @Date: 2018-06-21 11:47
 */
@Aspect
@Component
public class ControllerTimeConsumingAspect {

    public ControllerTimeConsumingAspect() {
        LogUtils.logInfo("*****************************ControllerTimeConsumingAspect init *****************************");
    }

    @Around("execution(* com.baozi.controller.*.*(..))")
    public Object logTome(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        String method = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().getName();

        Object ret = pjp.proceed();
        LogUtils.logInfo("接口耗时统计<" + className + "." + method + "> 耗时 <" + (System.currentTimeMillis() - begin) + ">ms");
        return ret;
    }
}
