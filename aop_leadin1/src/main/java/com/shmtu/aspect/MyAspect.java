package com.shmtu.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("myAspect")
@Aspect
public class MyAspect {

   @Before(value = "execution(public void com.shmtu.service.impl.SomeServiceImpl.doSome())")
    public void myBefore(JoinPoint jp){
       //      获取方法的定义
       System.out.println("获取方法的签名（定义）"+jp.getSignature());
       System.out.println("获取方法的名称"+jp.getSignature().getName());

//       获取方法的实参
       Object args[] =  jp.getArgs();
       for (Object ob:args
       ) {
           System.out.println("参数 = "+ob);
       }

       System.out.println("前置通知， 目标方法前的执行时间："+new Date());
    }

}
