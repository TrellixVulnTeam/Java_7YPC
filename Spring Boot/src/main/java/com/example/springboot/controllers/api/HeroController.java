package com.example.springboot.controllers.api;

import com.example.springboot.entities.Hero;
import com.example.springboot.repositories.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api")
public class HeroController {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

//    @RequestMapping(value = "/hero")
//    public String index() {
//        return "/hero";
//    }


    @GetMapping("/heroes")
    public List<Hero> index() {
        return (List<Hero>) heroRepository.findAll();
    }

    @GetMapping("/heroes/{id}")
    public ResponseEntity<Hero> getHeroesById(@PathVariable("id") int id) {
        Optional<Hero> tutorialData = heroRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
