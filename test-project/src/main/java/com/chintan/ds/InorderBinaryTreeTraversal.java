package com.chintan.ds;

import java.util.Stack;

public class InorderBinaryTreeTraversal {

    public static class TreeNode<T> {
        T data;
        TreeNode left;
        TreeNode right;

        TreeNode(T data) {
            this.data = data;
        }
    }

    private static void inorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            inorderTraversalRecursive(node.left);
            System.out.print(node.data + " ");
            inorderTraversalRecursive(node.right);
        }
    }

    private static void preorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversalRecursive(node.left);
            preorderTraversalRecursive(node.right);
        }
    }

    private static void postorderTraversalRecursive(TreeNode node) {
        if (node != null) {
            postorderTraversalRecursive(node.left);
            postorderTraversalRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    private static void printLeafNodes(TreeNode node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            } else {
                printLeafNodes(node.left);
                printLeafNodes(node.right);
            }
        }
    }

    private static void inorderTraversalIterative(TreeNode rootNode) {
        Stack<TreeNode<Integer>> stack = new Stack<>();

        TreeNode currentNode = rootNode;

        while(!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode node = stack.pop();
                System.out.print(node.data + " ");
                currentNode = node.right;
            }
        }
    }

    private static void preorderTraversalIterative(TreeNode rootNode) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode currentNode = rootNode;

        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                System.out.print(currentNode.data + " ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode node = stack.pop();
                currentNode = node.right;
            }
        }
    }

    private static  void levelOrderTraversal(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return;
        }

        if (leftNode != null) {
            System.out.print(leftNode.data + " ");
        }

        if (rightNode != null) {
            System.out.print(rightNode.data + " ");
        }

        if (leftNode != null) {
            levelOrderTraversal(leftNode.left, leftNode.right);
        }

        if (rightNode != null) {
            levelOrderTraversal(rightNode.left, rightNode.right);
        }
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lheight = height(node.left);
        int rheight = height(node.right);

        return Math.max(lheight + 1, rheight + 1);
    }

    private static void printGivenLevel(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data + " ");
        }

        if(level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }

    private static void levelOrderTraversal2(TreeNode rootNode) {
        int height = height(rootNode);

        for (int i = 1; i <= height; i++) {
            printGivenLevel(rootNode, i);
        }
    }

    private static void findLevel(TreeNode<Integer> node, int findValue, int level) {
        if (node != null) {
            if (node.data == findValue) {
                System.out.println("The Level of node " + findValue + " is: " + level);
            } else {
                findLevel(node.left, findValue, level + 1);
                findLevel(node.right, findValue, level + 1);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode<Integer> rootNode = new TreeNode<>(80);
        TreeNode<Integer> node40 = new TreeNode<>(40);
        TreeNode<Integer> node20 = new TreeNode<>(20);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        TreeNode<Integer> node30 = new TreeNode<>(30);
        TreeNode<Integer> node60 = new TreeNode<>(60);
        TreeNode<Integer> node50 = new TreeNode<>(50);
        TreeNode<Integer> node70 = new TreeNode<>(70);
        TreeNode<Integer> node120 = new TreeNode<>(120);
        TreeNode<Integer> node100 = new TreeNode<>(100);
        TreeNode<Integer> node90 = new TreeNode<>(90);
        TreeNode<Integer> node110 = new TreeNode<>(110);
        TreeNode<Integer> node140 = new TreeNode<>(140);
        TreeNode<Integer> node130 = new TreeNode<>(130);
        TreeNode<Integer> node150 = new TreeNode<>(150);

        rootNode.left = node40;
        rootNode.right = node120;
        node40.left = node20;
        node40.right = node60;
        node20.left = node10;
        node20.right = node30;
        node60.left = node50;
        node60.right = node70;
        node120.left = node100;
        node120.right = node140;
        node100.left = node90;
        node100.right = node110;
        node140.left = node130;
        node140.right = node150;

        System.out.print("Inorder: "); inorderTraversalRecursive(rootNode);
        System.out.println();
        System.out.print("Preorder: "); preorderTraversalRecursive(rootNode);
        System.out.println();
        System.out.print("Postorder: "); postorderTraversalRecursive(rootNode);
        System.out.println();
        System.out.println("===========================");
        System.out.print("Inorder: "); inorderTraversalIterative(rootNode);
        System.out.println();
        System.out.print("Preorder: "); preorderTraversalIterative(rootNode);
        System.out.println();
        System.out.println("===========================");
        //System.out.print("Level order: "); levelOrderTraversal(rootNode, null);
        System.out.print("Height: " + height(rootNode));
        System.out.println();
        System.out.print("Level order: "); levelOrderTraversal2(rootNode);
        System.out.println();
        System.out.print("Leaf Nodes: "); printLeafNodes(rootNode);
        System.out.println();
        findLevel(rootNode, 130, 1);
    }
}
