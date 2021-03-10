package com.klinger.JavaProjectOne;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.klinger.JavaProjectOne.domain.Categoria;
import com.klinger.JavaProjectOne.repositories.CategoriaRepository;

@SpringBootApplication
public class JavaProjectOneApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository; 
	
	public static void main(String[] args) {
		SpringApplication.run(JavaProjectOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null,"informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
