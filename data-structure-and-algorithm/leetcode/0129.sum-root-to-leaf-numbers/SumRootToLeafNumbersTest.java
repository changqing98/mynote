import org.junit.Test;

import static org.junit.Assert.*;

public class SumRootToLeafNumbersTest {

	@Test
	public void sumNumbers() {
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(9);
		node1.left = node2;
		node1.right = new TreeNode(0);
		node2.left = new TreeNode(5);
		node2.right = new TreeNode(1);
		var demo = new SumRootToLeafNumbers();
		assertEquals(1026, demo.sumNumbers(node1));
	}
}
