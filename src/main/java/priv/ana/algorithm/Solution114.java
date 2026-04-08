package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution114 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            treeNode.left = null;
            if (i < list.size() - 1)
                treeNode.right = list.get(i + 1);
            else
                treeNode.right = null;
        }
    }
}
