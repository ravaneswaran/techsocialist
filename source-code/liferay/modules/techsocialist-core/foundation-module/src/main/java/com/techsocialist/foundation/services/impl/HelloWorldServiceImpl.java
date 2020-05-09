package com.techsocialist.foundation.services.impl;

import com.techsocialist.foundation.services.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public int add(int op1, int op2) {
        return op1 + op2;
    }
}
