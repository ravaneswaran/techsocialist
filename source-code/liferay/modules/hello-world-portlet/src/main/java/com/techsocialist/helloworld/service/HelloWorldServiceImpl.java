package com.techsocialist.helloworld.service;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = HelloWorldService.class)
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String greetTheWorld() {
        return "Hello World";
    }
}
