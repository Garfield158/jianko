package com.x.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class StartSpringboot {
    public static void main(String[] args) {
    //是否过期
    try{
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-15");
        Date now = new Date();
        if(date.getTime()-now.getTime()>=0){
            SpringApplication.run(StartSpringboot.class, args);
        }else{
            System.out.println("已过期！请与开发商联系");
        }
    }catch (Exception e){

    }

    }
}
