class Solution {
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        traverse(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return ans;
    }

    public void traverse(TreeNode currentNode, int targetSum, long sumSoFar) {
        if (currentNode == null) return;

        sumSoFar += currentNode.val;
        if (sumSoFar == targetSum) ans++;
        traverse(currentNode.left, targetSum, sumSoFar);
        traverse(currentNode.right, targetSum, sumSoFar);
    }
}