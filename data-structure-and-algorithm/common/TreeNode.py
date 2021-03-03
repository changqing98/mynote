class TreeNodeTraversal:
	def __init__(self, val=0, left=None, right=None):
		self.val = val
		self.left = left
		self.right = right


root5 = TreeNodeTraversal(5, None, None)
root4 = TreeNodeTraversal(4, None, None)
root3 = TreeNodeTraversal(3, None, None)
root2 = TreeNodeTraversal(2, root4, root5)
root1 = TreeNodeTraversal(1, root2, root3)
