package com.jangjangyi.demospring.publisher;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

public class MyEventHandler {
    public MyEventHandler() {
    }

    @EventListener
    public void handle(MyEvent event){
        System.out.println("이벤트 받았다. 데이터는 " + event.getData() + ", 소스는 " + event.getSource());
    }
}
