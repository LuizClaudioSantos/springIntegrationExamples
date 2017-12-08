package me.luizclaudiosantos.queueChannel;

import me.luizclaudiosantos.queueChannel.integration.PrinterGateway;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class QueueChannelApplication implements ApplicationRunner {

	@Autowired
	private PrinterGateway gateway;


	public static void main(String[] args) {
		SpringApplication.run(QueueChannelApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();


		for(int x = 0; x < 10; x++){
			Message<String> message = MessageBuilder
					.withPayload("Print message paylod for " + x)
					.setHeader("Message Number ", x)
					.build();
			System.out.println("Sending Message " + x);
			futures.add(this.gateway.print(message));
		}


		/*
		futures = Stream
				.iterate(1 ,i -> i + 1)
				.map(n -> MessageBuilder.withPayload("Print message paylod for " + n).setHeader("Message Number ", n).build())
				.map(message -> this.gateway.print(message))
				.limit(10).collect(Collectors.toList());

		futures.forEach(future -> {
			try {
				System.out.println(future.get().getPayload());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
        */

		for(Future<Message<String>> future: futures){
		    System.out.println(future.get());
        }
	}
}
