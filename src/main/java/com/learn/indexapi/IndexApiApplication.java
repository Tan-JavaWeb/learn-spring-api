package com.learn.indexapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.indexapi.entities.Demo;

@SpringBootApplication
public class IndexApiApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(IndexApiApplication.class);

	@Autowired
	private DemoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(IndexApiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		log.info("StartApplication...");
		Demo demo = new Demo();
		demo.setId(Long.valueOf(1));
		demo.setName("Java");
		repository.save(demo);
		demo = new Demo();
		demo.setId(Long.valueOf(2));
		demo.setName("Node");
		repository.save(demo);
		demo = new Demo();
		demo.setId(Long.valueOf(3));
		demo.setName("Python");
		repository.save(demo);

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x.getId()));
		
		System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));
	}
}