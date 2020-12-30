package com.jangjangyi.demospring.repository;

import com.jangjangyi.demospring.book.Book;
import com.jangjangyi.demospring.book.BookRepository;
import com.jangjangyi.demospring.book.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class findRepositoryBean {
    ApplicationContext ac = new AnnotationConfigApplicationContext(SampleConfig.class);

    @Test
    public void findBean() {
        BookRepository bean = ac.getBean("bookRepository",BookRepository.class);
        Assertions.assertThat(bean).isNotNull();

    }

    @Test
    public void allFindBeans() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Configuration
    static class SampleConfig {
        @Bean
        public BookRepository bookRepository(){
            return new BookRepository();
        }

        @Bean
        public BookService bookService() {
            return new BookService(new BookRepository());
        }
    }
}
