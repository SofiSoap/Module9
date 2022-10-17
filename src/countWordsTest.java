import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

class countWordsTest {

	@Test
	void test() {
		Module7 test = new Module7();
		TreeMap<String, Integer> output;
		try {
			output = Module7.countWords("test.txt");
			assertTrue(output.containsKey("test"));
			assertTrue(output.containsValue(1));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
