package main.java.leetcode;

import main.java.amazon.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
In: [1,null,2,3,4]
Expected Out: [1,3,4,2]
 */

class TraverseBinaryTreeBoundaryAntiClockWise {
    private List<Integer> res;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        res = new ArrayList<Integer>();

        if(root != null) {
            res.add(root.val);
            traverseLeft(root.left);

            traverseLeaves(root.left);
            traverseLeaves(root.right);

            traverseRight(root.right);
        }

        return res;
    }

    private void traverseLeft(TreeNode root) {
        if(root != null) {
            if(root.left != null) {
                this.res.add(root.val);
                traverseLeft(root.left);
            } else if(root.right != null) {
                this.res.add(root.val);
                traverseLeft(root.right);
            }
        }
    }

    private void traverseLeaves(TreeNode root) {
        if(root != null) {
            traverseLeaves(root.left);
            if(root.left == null && root.right == null)
                this.res.add(root.val);
            traverseLeaves(root.right);
        }
    }

    private void traverseRight(TreeNode root) {
        if(root != null) {
            if(root.right != null) {
                traverseRight(root.right);
                this.res.add(root.val);
            } else if(root.left != null) {
                traverseRight(root.left);
                this.res.add(root.val);
            }
        }
    }

}
