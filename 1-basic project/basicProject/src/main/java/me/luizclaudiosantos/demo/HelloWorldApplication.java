package me.luizclaudiosantos.demo;

import me.luizclaudiosantos.demo.integration.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HelloWorldApplication implements ApplicationRunner {

	@Autowired
    @Qualifier("inputChannel")
	private DirectChannel inputChannel;

	//@Autowired
    //@Qualifier("outputChannel")
    //private DirectChannel outputChannel;

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {


		Message<String> message = MessageBuilder
				.withPayload("Hello World, from a builder pattern")
				.setHeader("key1", "value1")
                .setHeader("key2", "value2")
                .build();

		//   inputChannel.send(message);

//		channel.subscribe(new MessageHandler() {
////			@Override
////			public void handleMessage(Message<?> message) throws MessagingException {
////				PrintService service = new PrintService();
////				service.print((Message<String>) message);
////			}
////		});

//        outputChannel.subscribe(new MessageHandler() {
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//			   System.out.print(message.getPayload());
//			}
//		});

		MessagingTemplate template = new MessagingTemplate();
		Message returnMessage = template.sendAndReceive(inputChannel, message);

		System.out.println(returnMessage.getPayload());
	}
}
