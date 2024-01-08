package onim.test

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class RabbitMQSender(
    private val rabbitTemplate: RabbitTemplate,
) {
    fun sendMessage(queueName: String, message: Any) {
        println("Sending message <$message>")
        rabbitTemplate.convertAndSend(queueName, message)
    }
}
