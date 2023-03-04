package com.cchojnowski.nestedsetmodel;

import com.cchojnowski.nestedsetmodel.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class NestedSetModelApplication implements CommandLineRunner {

    private final CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(NestedSetModelApplication.class, args);
    }

    @Override
    public void run(String... args){
        categoryService.addChildToParentWithChildren("PORTELE2", 6L);
    }
}
