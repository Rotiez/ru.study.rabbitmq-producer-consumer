package ru.study.rabbitmqconsumer.service

import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
@EnableRabbit
class RabbitMqConsumerService {

    private val log = LoggerFactory.getLogger(RabbitMqConsumerService::class.java)

    @Value("\${spring.rabbitmq.default-props.queue}")
    private lateinit var queue: String

    @RabbitListener(queues = ["\${spring.rabbitmq.default-props.queue}"])
    fun processMyQueue(message: String) {
        log.info("Received new message in '$queue' queue: [$message]")
    }
}