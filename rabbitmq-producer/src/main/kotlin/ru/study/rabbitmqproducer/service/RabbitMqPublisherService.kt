package ru.study.rabbitmqproducer.service

import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import ru.study.rabbitmqproducer.configuration.DefaultRabbitMqProperties
import ru.study.rabbitmqproducer.model.MessageData

@Service
class RabbitMqPublisherService(
    @Qualifier("template")
    private val rabbitTemplate: AmqpTemplate,
    private val properties: DefaultRabbitMqProperties,
) {

    fun publishMessage(messageData: MessageData){
        if (messageData.exchange.isNullOrEmpty() || messageData.routingKey.isNullOrEmpty()) {
            rabbitTemplate.convertAndSend(properties.exchange, properties.routingKey, messageData.message)
        } else {
            rabbitTemplate.convertAndSend(messageData.exchange, messageData.routingKey, messageData.message)
        }
    }


}