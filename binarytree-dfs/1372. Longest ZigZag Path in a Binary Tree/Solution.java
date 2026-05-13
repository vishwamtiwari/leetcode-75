class Solution {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        traverse(root.left, true, 1);
        traverse(root.right, false, 1);
        return res;
    }

    private void traverse(TreeNode currentNode, boolean isLeft, int len) {
        if (currentNode == null) return;

        res = Math.max(res, len);
        if (isLeft) {
            traverse(currentNode.right, false, len + 1);
            traverse(currentNode.left, true, 1);
        } else {
            traverse(currentNode.left, true, len + 1);
            traverse(currentNode.right, false, 1);
        }
    }
}