package io.sqs.springsqproducer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MessageSenderTest {

    private static final Logger logger = LoggerFactory.getLogger(MessageSenderTest.class.getName());

    @Test
    void sendBookForUpdate() {
        logger.info("test with message channel.");
    }
}
