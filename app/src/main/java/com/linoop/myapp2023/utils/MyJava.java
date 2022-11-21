package com.linoop.myapp2023.utils;

public class MyJava {
    public static void main(String[] args) {
        MyInterface myInterface = (str)-> {
            System.out.println(str);
        };

        myInterface.changeTo("Hiiii");
    }
}

@FunctionalInterface
interface MyInterface {
    void changeTo(String str);
}

