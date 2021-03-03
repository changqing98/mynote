from typing import List

import TreeNode


class InOrderTraversal:
	def inorderTraversal(self, root: TreeNode) -> List[int]:
		result = []
		stack = []
		while root or stack:
			while root:
				stack.append(root)
				root = root.left
			root = stack.pop()
			result.append(root.val)
			root = root.right
		return result
