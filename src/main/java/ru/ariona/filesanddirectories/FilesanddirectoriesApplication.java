package ru.ariona.filesanddirectories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class FilesanddirectoriesApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FilesanddirectoriesApplication.class, args);
    }

}
