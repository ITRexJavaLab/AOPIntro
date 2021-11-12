package com.itrex.java.lab.service.impl;

import com.itrex.java.lab.annotation.MeasureExecutionTime;
import com.itrex.java.lab.service.SimpleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleServiceImpl implements SimpleService {

    private static final String HELLO_MSG_PATTERN = "Hello %s !!!!";

    @Override
    @MeasureExecutionTime
    public void sayHelloToPerson(String personName) throws InterruptedException {
        log.info(String.format(HELLO_MSG_PATTERN, personName));
        waitSomeTime(5000);
    }

    @Override
    @MeasureExecutionTime
    public synchronized void waitSomeTime(Integer waitTime) throws InterruptedException {
        log.info("Start waiting");
        wait(waitTime);
        log.info("End waiting");
    }

}
