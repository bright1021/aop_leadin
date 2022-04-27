package com.ban02.utils;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {

    @AfterReturning(value = "execution(* *..SomeServiceImpl.doSome(..))",returning = "res")
    public void myAfter(Object res){

        String s = null;
        if (res != null) {
            s =(String) res;
        }
        System.out.println("=====后置通知+增加功能===="+s);
    }
}
