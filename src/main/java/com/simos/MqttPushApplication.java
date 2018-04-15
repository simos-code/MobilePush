package com.simos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by l2h on 18-4-15.
 * Desc: spring boot 应用main入口
 * @author l2h
 */
@SpringBootApplication
public class MqttPushApplication {
    public static void main(String[]args){
        SpringApplication.run(MqttPushApplication.class,args);
    }
}
