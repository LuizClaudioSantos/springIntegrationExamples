package me.luizclaudiosantos.fileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FileReaderAdapter implements ApplicationRunner {




	public static void main(String[] args) {
		SpringApplication.run(FileReaderAdapter.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}
