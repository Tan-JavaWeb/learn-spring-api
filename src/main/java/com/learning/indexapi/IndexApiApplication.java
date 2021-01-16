package com.learning.indexapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		repository.save(new Demo(Long.valueOf(1), "Java"));
		repository.save(new Demo(Long.valueOf(2), "Node"));
		repository.save(new Demo(Long.valueOf(3), "Python"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x.getId()));
		
		System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Node')");
        repository.findByName("Node").forEach(x -> System.out.println(x));
	}
}