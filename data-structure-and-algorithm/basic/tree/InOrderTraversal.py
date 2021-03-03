from typing import List

import TreeNodeTraversal


class InOrderTraversal:
	def inorderTraversal(self, root: TreeNodeTraversal) -> List[int]:
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
