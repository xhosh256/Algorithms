package Algos.TreesAlgos;

import utils.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeTraversals {
    public static void DFS(BinaryTree tree) {
        DFS(tree.root);
        System.out.print("\b\b\b\b");
    }
    private static void DFS(BinaryTree.Node node) {
        if(node == null) return;
        System.out.print(node.val +" -> ");

        DFS(node.left);
        DFS(node.right);
    }

    public static void BFS(BinaryTree tree) {
        Queue<BinaryTree.Node> q = new ArrayDeque<>();
        q.add(tree.root);

        while(!q.isEmpty()) {
            BinaryTree.Node node = q.poll();

            System.out.print(node.val+" -> ");
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
        System.out.println("\b\b\b\b");
    }

    public static void inOrder(BinaryTree tree) {
        inOrder(tree.root);
        System.out.println("\b\b\b\b");
    }
    private static void inOrder(BinaryTree.Node node) {
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.val+" -> ");
        inOrder(node.right);
    }

    public static void preOrder(BinaryTree tree) {
        preOrder(tree.root);
        System.out.println("\b\b\b\b");
    }
    private static void  preOrder(BinaryTree.Node node) {
        if(node == null) return;

        System.out.print(node.val+" -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(BinaryTree tree) {
        postOrder(tree.root);
        System.out.println("\b\b\b\b");
    }
    private static void  postOrder(BinaryTree.Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" -> ");
    }
}
