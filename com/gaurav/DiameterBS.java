package com.gaurav;
import java.util.*;

//https://leetcode.com/problems/diameter-of-binary-tree
public class DiameterBS {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        private int maxDiameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            computeHeight(root);
            return maxDiameter;
        }

        private int computeHeight(TreeNode node) {
            if (node == null) return 0;
            int leftHeight = computeHeight(node.left);
            int rightHeight = computeHeight(node.right);
            // potential diameter through this node:
            int candidate = leftHeight + rightHeight;
            if (candidate > maxDiameter) {
                maxDiameter = candidate;
            }
            // return height for parent
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }


