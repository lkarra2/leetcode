package main.java.amazon;

class IsBST {

    // Function to check if given Binary tree is a BST (left subtree smaller than root value, right subtree values greater)

    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBSTHelper(TreeNode node, long min, long max) {
        if(node == null)
            return true;
        if(node.val <= min || node.val >= max)
            return false;
        return ((isBSTHelper(node.left, min, node.val)) && (isBSTHelper(node.right, node.val, max)));
    }
}