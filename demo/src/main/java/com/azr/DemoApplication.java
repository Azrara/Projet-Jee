package com.azr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azr.dao.ProduitRepository;
import com.azr.entities.Produits;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ProduitRepository produitrepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
