package io.sqs.springsqproducer;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@SpringBootTest(classes = BookProducerApplication.class)
@RunWith(SpringRunner.class)
class BookProducerApplicationTest {

	@Test
	public void applicationContextTest() {
		BookProducerApplication.main(new String[] {});
	}

}
