package com.manoharvallabi.notification;

import com.manoharvallabi.amqp.RabbitMQMessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.manoharvallabi.amqp","com.manoharvallabi.notification"})
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

/*    @Bean
    CommandLineRunner commandLineRunner
            (RabbitMQMessageProducer rabbitMQMessageProducer,
             NotificationConfig notificationConfig) {
        return args -> {
            rabbitMQMessageProducer.publish("test",notificationConfig.getInternalExchange(), notificationConfig.getInternalNotificationRoutingKey());
        };

    }*/
}