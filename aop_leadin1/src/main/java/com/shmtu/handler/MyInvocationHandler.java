package com.shmtu.handler;

import com.shmtu.tools.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    public Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    public MyInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object =null;
        //在方法之前输入日志
        ServiceTools.doLog();
        //执行目标方法
        object = method.invoke(target,args);//doSome方法
        ServiceTools.doTrans();
        return object;

    }
}
