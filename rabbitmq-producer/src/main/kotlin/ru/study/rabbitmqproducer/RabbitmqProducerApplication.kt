package ru.study.rabbitmqproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitmqProducerApplication

fun main(args: Array<String>) {
    runApplication<RabbitmqProducerApplication>(*args)
}
