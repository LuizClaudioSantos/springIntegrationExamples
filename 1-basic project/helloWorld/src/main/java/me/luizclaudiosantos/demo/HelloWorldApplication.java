package me.luizclaudiosantos.demo;

import me.luizclaudiosantos.demo.integration.CustomGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelloWorldApplication implements ApplicationRunner {

	@Autowired
	private CustomGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		gateway.print("Hello World");
	}
}
