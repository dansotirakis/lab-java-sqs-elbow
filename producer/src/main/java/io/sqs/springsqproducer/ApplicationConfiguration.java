package io.sqs.springsqproducer;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.messaging.config.QueueMessageHandlerFactory;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;

import java.util.Collections;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

    @Bean
    public QueueMessageHandlerFactory queueMessageHandlerFactory(final AmazonSQSAsync amazonSQSAsync,
                                                                 final ObjectMapper mapper) {
        final QueueMessageHandlerFactory queueHandlerFactory = new QueueMessageHandlerFactory();
        queueHandlerFactory.setAmazonSqs(amazonSQSAsync);
        queueHandlerFactory.setArgumentResolvers(
                Collections.singletonList(new PayloadMethodArgumentResolver(jackson2MessageConverter(mapper))));
        return queueHandlerFactory;
    }

    private MessageConverter jackson2MessageConverter(final ObjectMapper mapper){

        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(mapper);
        return converter;
    }

}
