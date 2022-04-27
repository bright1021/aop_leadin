package com.ban02.service.impl;

import com.ban02.service.SomeService;
import org.springframework.stereotype.Service;


/**
 * @author 常亮同学1021
 */
@Service("someServiceTarget1")
public class SomeServiceImpl implements SomeService {
    @Override
    public String doSome(String name, int age) {
        System.out.println("===业务方法===");
        return "我就是业务方法的返回值";
    }

}
