class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // If one is null and the other is not
        if (p == null || q == null) {
            return false;
        }

        // Check values and recursive subtrees
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return false;
    }
}