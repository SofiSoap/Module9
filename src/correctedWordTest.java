import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class correctedWordTest {

	@Test
	void test() {
		Module7 test = new Module7();
		String output = Module7.correctWord("PiZZa");
		assertEquals("pizza",output);
	}

}
