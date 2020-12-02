# [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

[LeetCode 426. Convert Binary Search Tree to Sorted Doubly Linked List](https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/)

## 问题

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。

为了让您更好地理解问题，以下面的二叉搜索树为例：

![bstdlloriginalbst](https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png) 

我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。

 ![bstdllreturndll](https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png)

特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。

## 解析
将二叉搜索数转换成排序的双向链表

1. 二叉搜索数的中序遍就是有序的
2. 设指针head指向链表头，pre指向上一次遍历结点

## 题解

```java
    Node head, pre;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        // 将头尾结点相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node cur){
        if(cur == null){
            return;
        }
        dfs(cur.left);
        if(pre != null){
            // pre表示上一次遍历的结点
            pre.right = cur;
        } else {
            // 仅当cur为第一个结点时pre才会为空，即cur为头节点，中序遍历的第一个结点
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

```