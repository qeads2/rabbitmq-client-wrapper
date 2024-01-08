package onim.test

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitTemplateConfig {
    @Bean
    fun connectionFactory(): ConnectionFactory {
        return CachingConnectionFactory().apply {
            host = "localhost"
            username = "guest"
            setPassword("guest")
        }

    }
    @Bean
    fun rabbitTemplate(myConnectionFactory: ConnectionFactory): RabbitTemplate {
        return RabbitTemplate().apply {
            connectionFactory = myConnectionFactory
            messageConverter = Jackson2JsonMessageConverter()
        }
    }
}