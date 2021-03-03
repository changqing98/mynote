# Definition for a binary tree node.
class TreeNodeTraversal:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class LowestCommonAncestor2:
    def lowestCommonAncestor(self, root: TreeNodeTraversal, p: TreeNodeTraversal, q: TreeNodeTraversal) -> TreeNodeTraversal:
        if root is None or p == root or q == root:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left is None:
            return right
        if right is None:
            return left
        return root


if __name__ == '__main__':
    LowestCommonAncestor2()
