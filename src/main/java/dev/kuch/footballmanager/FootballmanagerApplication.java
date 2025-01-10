package dev.kuch.footballmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class FootballmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballmanagerApplication.class, args);
    }

}
