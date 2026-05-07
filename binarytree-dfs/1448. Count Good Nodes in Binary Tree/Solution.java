class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return count;
    }

    public void traverse(TreeNode currentNode, int maxSoFar) {
        if (currentNode == null) return;
        if (currentNode.val >= maxSoFar) count++;
        int currentMax = Math.max(maxSoFar, currentNode.val);
        traverse(currentNode.left, currentMax);
        traverse(currentNode.right, currentMax);
    }
}