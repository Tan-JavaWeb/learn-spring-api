package com.learn.indexapi;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.indexapi.entities.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long>{
	List<Demo> findByName(String name);
}
