package cn.rectcircle.learn.quartz.service;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl {

    public void testMethod() {
        System.out.println("==========");
        System.out.println("service called");
        System.out.println("==========");
    }
}