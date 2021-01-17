package com.example.demo;

import com.example.demo.controller.PerformanceInteceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLOutput;
import java.util.Arrays;

@SpringBootApplication
@RestController
public class HelloApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new PerformanceInteceptor());

    }

    @RequestMapping("/hello")
    public String hello(){
        return  "hellp world!";
    }

    @RequestMapping("/")
    public String testLambda(){
        Arrays.asList("Foo","Boo").stream()
//                .filter(s->s.equalsIgnoreCase("boo"))
//                .map(s -> s.toUpperCase())
//                .forEach(System.out::println)
                .forEach(s -> System.out.println(s));


        Arrays.stream(new String[]{"aaa","bbb","ccc"})
                .map(s -> Arrays.asList(s))
//                .flatMap(l->l.stream())
                .forEach(System.out::println);
        return "s" ;
    }
}
