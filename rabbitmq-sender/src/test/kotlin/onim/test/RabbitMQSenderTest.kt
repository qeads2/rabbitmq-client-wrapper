package onim.test

import onim.test.notification.UserJoined
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestApplication::class])
class RabbitMQSenderTest @Autowired constructor (
    private val sender: RabbitMQSender,
){

    @Test
    fun testDefaultHandler() {
        sender.sendMessage("test-queue", "Hello World!")
        sender.sendMessage("test-queue", "Hello World!")
        sender.sendMessage("test-queue1", "Hello World!")
    }

    @Test
    fun testUserJoined() {
//        (1..5).forEach {
            sender.sendMessage("test-queue", UserJoined(
                id = 1,
                email = "name-1",
                duplicated = false,
            )
            )
//        }
    }
}