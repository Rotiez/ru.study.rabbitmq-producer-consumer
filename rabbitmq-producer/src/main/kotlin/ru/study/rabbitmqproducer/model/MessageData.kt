package ru.study.rabbitmqproducer.model

data class MessageData (
    val message: String,
    val exchange: String?,
    val routingKey: String?,
)