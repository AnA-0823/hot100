package priv.ana.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution98 {
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

    public boolean isValidBST(TreeNode root) {
        LinkedList<Integer> integers = new LinkedList<>();
        inorder(root, integers);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i - 1) >= integers.get(i)) return false;
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
