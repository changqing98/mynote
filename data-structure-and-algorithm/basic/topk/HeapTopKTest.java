import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class HeapTopKTest {

	@Test
	public void listTopK() {
		int[] array = new int[]{1, 4, 5, 7, 9, 2, 3, 4};
		var test = new HeapTopK();
		var result = test.listTopK(array, 4);
		System.out.print(Arrays.toString(result));
	}
}
