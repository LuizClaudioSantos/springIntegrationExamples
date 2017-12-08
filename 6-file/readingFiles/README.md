#Basic Projet
This is a basic project that can be used as model to other projects.


## integration-context.xml
This is the configuration file to our integration file. Note that I'm using the annotation @ImportResource to import the configuration file in my Spring Class configuration style.

```
@ImportResource("integration-context.xml")
public class IntegrationConfig {
```

## Message

Here you can see a generic way to declare a message:

```
  Message<String> message = MessageBuilder
	.withPayload("Hello World, from a builder pattern")
	.setHeader("key1", "value1")
     setHeader("key2", "value2")
    .build();
```
So we need a channel to send the message


## Channel

Declare the channel in the integration-context.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:int="http://www.springframework.org/schema/integration"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/integration http://www.springframework.org/schema/integration/spring-integration-4.3.xsd">

    <int:channel id="messageChannel"/>
</beans>
```

You have to autowired the channel

```
	@Autowired
	private DirectChannel channel;
```

Then create the channel and send the message through it.

```
	channel.subscribe(new MessageHandler() {
			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				PrintService service = new PrintService();
				service.print((Message<String>) message);
			}
	});

	channel.send(message);
```