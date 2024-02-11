package ru.study.rabbitmqproducer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.study.rabbitmqproducer.service.RabbitMqPublisherService
import ru.study.rabbitmqproducer.model.MessageData

@RestController
@RequestMapping("/rabbitmq")
class RabbitMqPublisherController(
    private val publisherService: RabbitMqPublisherService,
) {

    @PostMapping("/send")
    fun publishMessage(@RequestBody messageData: MessageData) {
        publisherService.publishMessage(messageData)
    }

}