class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode currentNode = rContains(root, val);
        root = currentNode;
        return root;
    }

    private TreeNode rContains(TreeNode currentNode, int val) {
        if (currentNode == null) return null;
        if (currentNode.val == val) return currentNode;

        if (val < currentNode.val) return rContains(currentNode.left, val);
        else return rContains(currentNode.right, val);
    }
}