class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Pop the leftmost node
            curr = stack.pop();
            
            // Decrement k and check if this is the k-th smallest element
            k--;
            if (k == 0) {
                return curr.val;
            }
            
            // Move to the right subtree
            curr = curr.right;
        }
        
        return -1; // Should never be reached for a valid BST and valid k
    }
}