package com.ssafy.hello.di1;

public class HelloMain {

    public static void main(String[] args) {
    	String greeting = "";
    	
        HelloMessageKor helloMessageKor = new HelloMessageKor();
//        HelloMessageEng helloMessageEng = new HelloMessageEng();
        
        greeting = helloMessageKor.helloKor("여러분");
//        greeting = helloMessageEng.helloEng("Everyone");
        
        System.out.println(greeting);
    }
    
}
