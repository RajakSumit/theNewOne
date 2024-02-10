package com.NewBlog.NewBlog11;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewBlog11Application {

	public static void main(String[] args) {SpringApplication.run(NewBlog11Application.class, args);}


	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();

	}

}
