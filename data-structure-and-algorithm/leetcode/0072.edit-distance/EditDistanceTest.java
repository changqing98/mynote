import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

	@Test
	void minDistance() {
		EditDistance test = new EditDistance();
		assertEquals(5, test.minDistance("horse", "ros"));
		assertEquals(5, test.minDistance("intention", "execution"));
	}
}
