package com.example.demo;

import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ArrayBlockingQueue;

@SpringBootApplication
class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setThreadPool(new QueuedThreadPool(512, 215, 60000, new ArrayBlockingQueue<>(10000)));
        return factory;
    }

}