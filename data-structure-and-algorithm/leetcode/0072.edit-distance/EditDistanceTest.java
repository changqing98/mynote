import org.junit.Test;

import static org.junit.Assert.*;

public class EditDistanceTest {

	@Test
	public void minDistance() {
		EditDistance test = new EditDistance();
		assertEquals(3, test.minDistance("horse", "ros"));
		assertEquals(5, test.minDistance("intention", "execution"));
	}
}
