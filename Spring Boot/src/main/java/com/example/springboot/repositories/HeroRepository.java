package com.example.springboot.repositories;

import com.example.springboot.entities.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Integer> {
}
