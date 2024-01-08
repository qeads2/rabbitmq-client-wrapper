package onim.test

interface RabbitMQReceiver {
    fun receiveMessage(message: String)
}