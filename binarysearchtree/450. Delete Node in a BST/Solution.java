class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        TreeNode currentNode = root;
        if (key < currentNode.val) {
            currentNode.left = deleteNode(currentNode.left, key);
        } else if (key > currentNode.val) {
            currentNode.right = deleteNode(currentNode.right, key);
        } else {
            if (currentNode.left == null && currentNode.right == null) return null;
            else if (currentNode.left == null) return currentNode.right;
            else if (currentNode.right == null) return currentNode.left;
            else {
                int successor = min(currentNode.right);
                currentNode.val = successor;
                currentNode.right = deleteNode(currentNode.right, successor);
            }
        }
        return currentNode;
    }

    private int min(TreeNode curr) {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }
}