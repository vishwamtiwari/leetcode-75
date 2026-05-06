class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leafNodes1 = new ArrayList<>();
        ArrayList<Integer> leafNodes2 = new ArrayList<>();

        traverse(root1, leafNodes1);
        traverse(root2, leafNodes2);

        return leafNodes1.equals(leafNodes2);
    }
    public void traverse(TreeNode root, ArrayList<Integer> leafs) {
        if (root.left == null && root.right == null) leafs.add(root.val);
        else  {
            if (root.left != null) traverse(root.left, leafs);
            if (root.right != null) traverse(root.right, leafs);
        }
    }
}