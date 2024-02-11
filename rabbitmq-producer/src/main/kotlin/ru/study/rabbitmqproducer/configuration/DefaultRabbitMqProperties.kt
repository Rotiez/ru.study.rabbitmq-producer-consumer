package ru.study.rabbitmqproducer.configuration

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "spring.rabbitmq.default-props")
data class DefaultRabbitMqProperties (

    val queue: String,

    val exchange: String,

    val routingKey: String

)
