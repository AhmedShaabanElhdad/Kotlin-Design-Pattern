package com.example.kotlindesignpattern.singleton;

public class JavaSingleton {
    //1- create private constructor
    private JavaSingleton(){
        System.out.println("Singleton Design Pattern");
    }

    //2- static reference of its class
    private static JavaSingleton instance = null;

    //3- static method to get instance of class
    //4- Globally accessible object reference
    public static JavaSingleton getInstance(){
        if (instance==null)
            instance = new JavaSingleton();
        return instance;
    }

    //3- static method to get instance of class
    //4- Globally accessible object reference
    //5- Consistency across multiple threads
    public static JavaSingleton getSafeInstance(){

        if (instance==null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new JavaSingleton();
                }
            }
        }
        return instance;
    }

    //3- static method to get instance of class
    //4- Globally accessible object reference
    //5- Consistency across multiple threads
    private synchronized static void createInstance() {
        if (instance == null) {
            instance = new JavaSingleton();
        }
    }



}
