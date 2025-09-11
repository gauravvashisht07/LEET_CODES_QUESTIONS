package com.gaurav;

public class LowestCommonAncestorBS {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> pathP = new ArrayList<>();
            List<TreeNode> pathQ = new ArrayList<>();
            // find paths
            dfsFindPath(root, p, pathP);
            dfsFindPath(root, q, pathQ);
            // compare
            int i = 0;
            while (i < pathP.size() && i < pathQ.size() && pathP.get(i) == pathQ.get(i)) {
                i++;
            }
            return pathP.get(i - 1);
        }

        private boolean dfsFindPath(TreeNode node, TreeNode target, List<TreeNode> path) {
            if (node == null) return false;
            path.add(node);
            if (node == target) return true;
            if (dfsFindPath(node.left, target, path) || dfsFindPath(node.right, target, path)) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }


}
