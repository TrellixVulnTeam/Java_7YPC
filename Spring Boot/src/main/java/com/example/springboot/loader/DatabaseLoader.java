package com.example.springboot.loader;

import com.example.springboot.entities.Hero;
import com.example.springboot.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final HeroRepository repository;

    @Autowired
    public DatabaseLoader(HeroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.repository.save(new Hero("Bob"));
    }


}
