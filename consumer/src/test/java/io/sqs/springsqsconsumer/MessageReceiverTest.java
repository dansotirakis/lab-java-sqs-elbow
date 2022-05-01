package io.sqs.springsqsconsumer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MessageReceiverTest {

    private static final Logger logger = LoggerFactory.getLogger(MessageReceiverTest.class.getName());

    @Test
    void receiveMessageFifo() {
        logger.info("test with message channel listener");
    }
}
