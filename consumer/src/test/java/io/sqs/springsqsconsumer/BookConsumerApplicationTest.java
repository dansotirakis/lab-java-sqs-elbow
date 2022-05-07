package io.sqs.springsqsconsumer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = BookConsumerApplication.class)
@RunWith(SpringRunner.class)
class BookConsumerApplicationTest {

	@Test
	public void applicationContextTest() {
		BookConsumerApplication.main(new String[] {});
	}

}
