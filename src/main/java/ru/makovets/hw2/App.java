package ru.makovets.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        System.out.println("CRUD application starting...\n\n"
                + "http://arch.homework/health - healthcheck uri\n"
                + "http://arch.homework/probe/live - liveness probe uri\n"
                + "http://arch.homework/probe/ready - readiness probe uri\n\n"
                + "http://arch.homework/api/v1 - API uri\n[GET, POST, PUT, PATCH, DELETE]\n\n"
                + "For example:\nGET http://arch.homework/api/v1/user - get all users\n\nJust a second...");
        SpringApplication.run(App.class, args);
    }
}
