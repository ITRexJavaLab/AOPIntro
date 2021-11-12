package com.itrex.java.lab.service;

public interface SimpleService {

    void sayHelloToPerson(String personName) throws InterruptedException;
    void waitSomeTime(Integer waitTime) throws InterruptedException;

}
