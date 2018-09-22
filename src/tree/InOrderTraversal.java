package tree;

import java.util.LinkedList;

/**
 * 二叉树的中序遍历
 */
public class InOrderTraversal {
    private static void recursion(TreeNode node) {
        if (node == null) return;
        recursion(node.left);
        System.out.println(node.val);
        recursion(node.right);
    }

    private static void nonRecursion(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode node = root.left;

        while (!stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            System.out.println(node.val);
            node = node.right;
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

}
