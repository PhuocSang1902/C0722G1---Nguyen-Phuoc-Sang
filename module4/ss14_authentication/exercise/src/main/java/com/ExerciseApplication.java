package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ExerciseApplication {

    public static void main(String[] args) {
//        SpringApplication.run(ExerciseApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("hahasd"));
    }

}
