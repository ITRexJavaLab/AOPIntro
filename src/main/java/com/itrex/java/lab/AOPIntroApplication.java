package com.itrex.java.lab;

import com.itrex.java.lab.config.AOPIntroConfiguration;
import com.itrex.java.lab.service.SimpleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class AOPIntroApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AOPIntroConfiguration.class);
        SimpleService simpleService = ctx.getBean(SimpleService.class);
        log.info("\n\nSimpleService class name: " + simpleService.getClass().getName() + "\n");

        simpleService.sayHelloToPerson("Some Person");

        log.info("\n\nbefore wait\n");
        simpleService.waitSomeTime(500);
        log.info("\n\nafter wait\n");
    }

}
