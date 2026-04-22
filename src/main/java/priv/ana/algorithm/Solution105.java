package priv.ana.algorithm;

import java.util.HashMap;

public class Solution105 {
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

    private final HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode f(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int rootIndex = indexMap.get(preorder[preL]);
        int leftNum = rootIndex - inL;
        root.left = f(preorder, preL + 1, preL + leftNum, inorder, inL, rootIndex - 1);
        root.right = f(preorder, preL + leftNum + 1, preR, inorder, rootIndex + 1, inR);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}
