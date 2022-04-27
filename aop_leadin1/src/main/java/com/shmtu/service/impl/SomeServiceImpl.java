package com.shmtu.service.impl;

import com.shmtu.service.SomeService;
import org.springframework.stereotype.Component;

@Component("someServiceTarget")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("===业务方法===");
    }
}
