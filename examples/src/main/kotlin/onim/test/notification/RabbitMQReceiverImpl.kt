package onim.test.notification

import onim.test.RabbitMQReceiver
import org.springframework.stereotype.Component

@Component
class RabbitMQReceiverImpl(
    private val notificationService: NotificationService,
): RabbitMQReceiver {

    override fun receiveMessage(message: String) {
        notificationService.sendNotification("send notification with message <$message>")
        println("RabbitMQ: Received message <$message>")
    }
}