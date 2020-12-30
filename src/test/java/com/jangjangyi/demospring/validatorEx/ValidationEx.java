package com.jangjangyi.demospring.validatorEx;
import com.jangjangyi.demospring.validationEx.Event;
import com.jangjangyi.demospring.validationEx.EventValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.validation.ValidatorAdapter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
@SpringBootTest
public class ValidationEx {
    @Autowired
    Validator validator;

    @Test
    public void validatorEx() {
        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("aaa2");
        Errors error = new BeanPropertyBindingResult(event, "event");

        validator.validate(event,error);
        System.out.println(error.hasErrors());
        error.getAllErrors().forEach(e ->{
            System.out.println("==== error code ====");
            Arrays.stream(e.getCodes()).forEach(System.out::println);
            System.out.println(e.getDefaultMessage());
        });
    }


}
