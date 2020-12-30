package com.jangjangyi.demospring.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class showPublisher {

    ApplicationContext ac = new AnnotationConfigApplicationContext(PublisherConfig.class);


    @Test
    public void findEvent() {
        MyEventHandler bean = ac.getBean(MyEventHandler.class);
        bean.handle(new MyEvent(this,100));
    }

    @Configuration
    static class PublisherConfig {
        @Bean
        public MyEventHandler myEventHandler() {
            return new MyEventHandler();
        }
    }
}
