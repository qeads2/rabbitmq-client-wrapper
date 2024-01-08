package onim.test

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig(
    @Value("\${spring.rabbitmq.host}")
    private val host: String,
    @Value("\${spring.rabbitmq.queueName}")
    private val queueName: String,

) {
    @Bean
    fun queue(): Queue {
        return Queue(queueName, false)
    }

    @Bean
    fun messageListenerAdapter(rabbitMQReceiver: RabbitMQReceiver): MessageListenerAdapter {
        return MessageListenerAdapter(rabbitMQReceiver, "receiveMessage")
    }

    @Bean
    fun connectionFactory(): ConnectionFactory {
        val factory = CachingConnectionFactory()
        factory.host = host
        factory.username = "guest"
        factory.setPassword("guest")
        return factory
    }

    @Bean
    fun container(listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {
        val container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory()
        container.setQueueNames(queueName)
        container.messageListener = listenerAdapter
        return container
    }
}