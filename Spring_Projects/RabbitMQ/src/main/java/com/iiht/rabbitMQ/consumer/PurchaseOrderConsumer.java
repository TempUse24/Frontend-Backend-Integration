package com.iiht.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.iiht.rabbitMQ.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	
	@Value("${ust.rabbitmq.queue}")
	String queuename;
	
	@Value("${ust.rabbitmq.exchange}")
	String exchange;
	
	@Value("${ust.rabbitmq.routingkey}")
	private String routingkey;
	
	@RabbitListener(queues="ust_queue")
	public void consumerMessageFromQueue(OrderStatus orderstatus) {
		System.out.println("Message received from Queue: "+orderstatus);
	}

}
