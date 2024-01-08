package onim.test

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [TestApplication::class])
class RabbitMQSenderTest @Autowired constructor (
    private val sender: RabbitMQSender,
){

    @Test
    fun test() {
        sender.sendMessage("test-queue", "Hello World!")
        sender.sendMessage("test-queue", "Hello World!")
        sender.sendMessage("test-queue1", "Hello World!")
    }
}