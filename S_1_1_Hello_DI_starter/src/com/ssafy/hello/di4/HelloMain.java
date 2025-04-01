package com.ssafy.hello.di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/applicationContext.xml");
        
        HelloMessage helloMessage = null;
        String greeting = "";
        
        helloMessage = (HelloMessage) context.getBean("kor");
//        helloMessage = context.getBean("kor", HelloMessage.class);
//        helloMessage = context.getBean("eng", HelloMessage.class);
        
        greeting = helloMessage.hello("여러분");
//        greeting = helloMessage.hello("Everyone");
        
        System.out.println(greeting);
        
        System.out.println("----------------------------------------");
        
        HelloMessage kor1 = context.getBean("kor", HelloMessage.class);
        HelloMessage kor2 = context.getBean("kor", HelloMessage.class);
        System.out.println(kor1 + " ::::: " + kor2);

    }
    
}
