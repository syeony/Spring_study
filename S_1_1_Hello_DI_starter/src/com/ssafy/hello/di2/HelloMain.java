package com.ssafy.hello.di2;

public class HelloMain {

    public static void main(String[] args) {
    	HelloMessage helloMessage = null;
    	String greeting = "";
    	
//        helloMessage = new HelloMessageKor();
        helloMessage = new HelloMessageEng();
        
        greeting = helloMessage.hello("여러분");
//        greeting = helloMessage.hello("Everyone");
        
        System.out.println(greeting);
    }
    
}
