from unittest import TestCase

from TreeNodeTraversal import root1
from basic.tree.InOrderTraversal import InOrderTraversal


class TestInOrderTraversal(TestCase):
	def test_inorder_traversal(self):
		inst = InOrderTraversal()
		result = inst.inorderTraversal(root1)
		self.assertEqual([4, 2, 5, 1, 3], result)
