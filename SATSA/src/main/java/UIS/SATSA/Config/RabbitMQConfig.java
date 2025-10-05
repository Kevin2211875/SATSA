package UIS.SATSA.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String FANOUT_EXCHANGE = "amq.fanout";
    public static final String DIRECT_EXCHANGE = "amq.direct";
    public static final String TOPIC_EXCHANGE = "amq.topic";

    public static final String NOTIFICACIONES_EXCHANGE = "notificaciones.exchange";
    public static final String NOTIFICACIONES_QUEUE = "notificaciones.queue";
    public static final String NOTIFICACIONES_ROUTING_KEY = "solicitud.estado";

    @Bean
    public TopicExchange notificacionesExchange() {
        return new TopicExchange(NOTIFICACIONES_EXCHANGE);
    }

    @Bean
    public Queue notificacionesQueue() {
        return new Queue(NOTIFICACIONES_QUEUE, true);
    }

    @Bean
    public Binding notificacionesBinding(Queue notificacionesQueue, TopicExchange notificacionesExchange) {
        return BindingBuilder.bind(notificacionesQueue)
                .to(notificacionesExchange)
                .with(NOTIFICACIONES_ROUTING_KEY);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public AmqpTemplate rabbitMQTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public void crearColaUsuario(Integer userId, RabbitAdmin rabbitAdmin, DirectExchange directExchange) {
        String queueName = "cola.notificaciones.usuario." + userId;
        String routingKey = "solicitud.estado.usuario." + userId;

        Queue queue = new Queue(queueName, true); // durable
        rabbitAdmin.declareQueue(queue);
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue).to(directExchange).with(routingKey));
    }
}
