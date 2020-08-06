package com.example.kotlindesignpattern.singleton

object Singleton{
    init {
        println("singleton Design Pattern")
    }
    fun doSomeThin(){

    }


}

//1- create private constructor
class SingletonWithLazyAndObject private constructor()  {
    init {
        println("singleton Design Pattern")
    }



    //3- static method to get instance of class
    //4- Globally accessible object reference
    //Holder object & lazy instance is used to ensure only one instance of Singleton is created.
    private object Holder {
        val INSTANCE = SingletonWithLazyAndObject()
    }

    //2- static reference of its class
    companion object {
        val instance: SingletonWithLazyAndObject by lazy { Holder.INSTANCE }
    }
}

//1- create private constructor
class SingletonWithoutObject private constructor() {

    companion object {
        //2- static reference of its class
        private var instance: SingletonWithoutObject? = null

        //3- static method to get instance of class
        //4- Globally accessible object reference
        fun getInstance(): SingletonWithoutObject? {
            if (instance == null) instance =
                SingletonWithoutObject()
            return instance
        }

        //3- static method to get instance of class
        //4- Globally accessible object reference
        //5- Consistency across multiple threads
        val safeInstance: SingletonWithoutObject?
            get() {
                if (instance == null) {
                    synchronized(SingletonWithoutObject::class.java) {
                        if (instance == null) {
                            instance = SingletonWithoutObject()
                        }
                    }
                }
                return instance
            }

        //3- static method to get instance of class
        //4- Globally accessible object reference
        //5- Consistency across multiple threads using Synchronized Annotation
        @Synchronized
        private fun createInstance() {
            if (instance == null) {
                instance = SingletonWithoutObject()
            }
        }
    }
    init {
        println("Singleton Design Pattern")
    }
}