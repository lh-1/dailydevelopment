package com.mjy.daily.demo;

public interface TestInterface {

    static String aa = "00";

    void test();

    default String find(){
        return "TestInterface ";
    }

    default public String find2(){
        return "TestInterface ";
    }

}
