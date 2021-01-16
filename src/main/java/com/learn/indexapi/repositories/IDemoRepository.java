package com.learn.indexapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.indexapi.entities.Demo;

public interface IDemoRepository extends JpaRepository<Demo, Long>{

}