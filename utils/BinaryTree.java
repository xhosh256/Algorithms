package utils;

// the data structure which implements BT/BST
public class BinaryTree {
    public static class Node {
        public int val;
        public Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
    public Node root = null;

    public BinaryTree(int[] nums) {
        root = build(nums, 0, nums.length-1);
    }
    private static Node build(int[] nums, int l, int r) {
        Node node = null;
        if(l==r) {
            node = new Node(nums[l]);
            return node;
        }
        int mid = (l+r)/2;
        node = new Node(nums[mid]);
        node.left = build(nums, l, mid-1);
        node.right = build(nums, mid+1, r);
        return node;
    }

}
