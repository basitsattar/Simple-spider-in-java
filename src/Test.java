import static org.junit.Assert.*;

import java.util.HashMap;

public class Test {

	@org.junit.Test
	public void test() {
		HashMap index = new HashMap();
		String searchString = "nothing";
		Main.populateHashMap(index, "testing/");
		String result = Main.search(index, searchString);
		assertEquals(result ,"/Users/abdulbasit/java workspace/Spider/testing/cvr.txt");
	}

}
