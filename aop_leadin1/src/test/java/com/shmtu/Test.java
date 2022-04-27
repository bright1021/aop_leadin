package com.shmtu;

import com.shmtu.handler.MyInvocationHandler;
import com.shmtu.service.SomeService;
import com.shmtu.service.impl.SomeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class Test {

    @org.junit.Test
    public void test01(){
        //创建代理对象
        SomeService target = new SomeServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(target);


        SomeService proxy = (SomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

        //通过代理对象执行业务方法,实现增强功能
        proxy.doSome();
    }

    @org.junit.Test
    public void test02(){
        String config = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SomeService proxy =(SomeService) ac.getBean("someServiceTarget");

        proxy.doSome();
    }
    @org.junit.Test
    public void test03(){
        String config = "applicationContext2.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        com.ban02.service.SomeService proxy = (com.ban02.service.SomeService) ac.getBean("someServiceTarget1");
        proxy.doSome("chang",20);

    }
}
