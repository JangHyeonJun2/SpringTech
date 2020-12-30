package com.jangjangyi.demospring.messageEx;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@SpringBootTest
public class MessageEx {
//    @Autowired
//    MessageSource messageSource;

    ApplicationContext ac = new AnnotationConfigApplicationContext(Message.class);


    @Test
    public void findMessage() {
        Assertions.assertThat(ac.getClass()).isNotNull();
        while (true){
            System.out.println(ac.getMessage("greeting", new String[]{"jangjangyi"}, Locale.KOREA));
            System.out.println(ac.getMessage("greeting", new String[]{"jangjangyi"}, Locale.getDefault()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    @Configuration
    static class Message {
        @Bean
        public MessageSource messageSource() {
            var messageSource = new ReloadableResourceBundleMessageSource();
            messageSource.setBasename("classpath:/messages");
            messageSource.setDefaultEncoding("UTF-8");
            messageSource.setCacheSeconds(3);
            return messageSource;
        }
    }
}
