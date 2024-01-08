package onim.test

interface RabbitMQReceiver {
    fun defaultHandler(message: Any)
}