package onim.test.notification

import com.fasterxml.jackson.databind.ObjectMapper
import onim.test.RabbitMQReceiver
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
@RabbitListener(queues = ["test-queue"])
class RabbitMQReceiverImpl(
    private val notificationService: NotificationService,
): RabbitMQReceiver {

    @RabbitHandler
    fun userJoined(userJoined: UserJoined) {
        notificationService.sendNotification("user joined: ${userJoined.id} / isDuplicated: ${userJoined.duplicated}")
        println("RabbitMQ: Received message <$userJoined>")
    }
    @RabbitHandler(isDefault = true)
    override fun defaultHandler(message: Any) {
        when (message) {
            is UserJoined -> userJoined(message)
            else -> unhandledMessage(message)
        }
    }
    fun unhandledMessage(message: Any) {
        println("Cannot handle message <$message>")
    }
}