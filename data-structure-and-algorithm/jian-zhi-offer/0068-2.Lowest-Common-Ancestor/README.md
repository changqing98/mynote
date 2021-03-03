# [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

## Problem

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例  2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

## Solution

1. 在左子树找 p 或 q 节点,先找到哪一就返回哪一个,记为 left
2. 在右子树找 p 或 q 节点,先找到哪一就返回哪一个,记为 right
3. 如果 left 为 null,则说明 p 和 q 都在 root 的右子树上，则返回 right（等于 p 或 q）就是最近公共父节点
4. 反之如何 right 为 null,则说明 p 和 q 都在 root 的左子树上，则返回 left（等于 p 或 q）就是最近公共父节点
5. 如果 left 和 right 都不为空，则说明 p 和 q 在 root 的两侧返回 root 即可

```java
    public static TreeNodeTraversal lowestCommonAncestor(TreeNodeTraversal root, TreeNodeTraversal p, TreeNodeTraversal q) {
        if(root == null || p == root || q == root){
            return root;
        }
        TreeNodeTraversal left = lowestCommonAncestor(root.left, p, q);
        TreeNodeTraversal right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

```
