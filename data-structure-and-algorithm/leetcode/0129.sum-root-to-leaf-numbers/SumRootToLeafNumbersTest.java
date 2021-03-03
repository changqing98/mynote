import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {

	@Test
	public void sumNumbers() {
		TreeNodeTraversal node1 = new TreeNodeTraversal(4);
		TreeNodeTraversal node2 = new TreeNodeTraversal(9);
		node1.left = node2;
		node1.right = new TreeNodeTraversal(0);
		node2.left = new TreeNodeTraversal(5);
		node2.right = new TreeNodeTraversal(1);
		var demo = new SumRootToLeafNumbers();
		assertEquals(1026, demo.sumNumbers(node1));
	}
}
