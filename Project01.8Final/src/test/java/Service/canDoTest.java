package Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class canDoTest {

	@Test
	void test() {
		boolean success = true;
		if(success) {
			System.out.println("Everything is fine");
		}else {
			System.out.println("Needs updating");
		}
	}

}
