package tryouts;

import java.util.*;

public class TryTrees {

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    /* Create a simple binary search tree
     * @return Node
     * Approach: Manual links for a small interview-friendly tree
     * Example: input 4,2,6,1,3,5,7 -> output root 4
     * */
    private static Node sampleTree() {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        return root;
    }

    /* Insert a value into a Binary Search Tree
     * @return void
     * Approach: Recursive insert based on smaller-left and greater-right rule
     * Example: input insert 8 -> output inorder [1, 2, 3, 4, 5, 6, 7, 8]
     * */
    public static void insertIntoBst() {
        Node root = sampleTree();
        insert(root, 8);
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        System.out.println(result);
    }

    private static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insert(root.left, value);
        else if (value > root.value) root.right = insert(root.right, value);
        return root;
    }

    /* Traverse a tree in inorder
     * @return void
     * Approach: Left, root, right
     * Example: input BST 4,2,6,1,3,5,7 -> output [1, 2, 3, 4, 5, 6, 7]
     * */
    public static void inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorder(sampleTree(), result);
        System.out.println(result);
    }

    private static void inorder(Node root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.value);
        inorder(root.right, result);
    }

    /* Traverse a tree in preorder
     * @return void
     * Approach: Root, left, right
     * Example: input BST 4,2,6,1,3,5,7 -> output [4, 2, 1, 3, 6, 5, 7]
     * */
    public static void preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorder(sampleTree(), result);
        System.out.println(result);
    }

    private static void preorder(Node root, List<Integer> result) {
        if (root == null) return;
        result.add(root.value);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    /* Traverse a tree in level order
     * @return void
     * Approach: Breadth-first search using Queue
     * Example: input BST 4,2,6,1,3,5,7 -> output [4, 2, 6, 1, 3, 5, 7]
     * */
    public static void levelOrderTraversal() {
        Node root = sampleTree();
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.value);
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        System.out.println(result);
    }

    /* Search a value in a Binary Search Tree
     * @return void
     * Approach: Use BST ordering to move left or right
     * Example: input search 5 -> output true
     * */
    public static void searchInBst() {
        System.out.println(search(sampleTree(), 5));
    }

    private static boolean search(Node root, int target) {
        if (root == null) return false;
        if (root.value == target) return true;
        return target < root.value ? search(root.left, target) : search(root.right, target);
    }

    /* Find height of a binary tree
     * @return void
     * Approach: Recursively take max height of left and right subtree
     * Example: input balanced tree with 3 levels -> output 3
     * */
    public static void treeHeight() {
        System.out.println(height(sampleTree()));
    }

    private static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /* Validate if a tree is a Binary Search Tree
     * @return void
     * Approach: Use min and max allowed range for each node
     * Example: input valid BST -> output true
     * */
    public static void validateBst() {
        System.out.println(isValidBst(sampleTree(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isValidBst(Node root, int min, int max) {
        if (root == null) return true;
        if (root.value <= min || root.value >= max) return false;
        return isValidBst(root.left, min, root.value) && isValidBst(root.right, root.value, max);
    }

    /* Use TreeSet for sorted unique values
     * @return void
     * Approach: TreeSet stores values in natural sorted order
     * Example: input [5, 1, 5, 3] -> output [1, 3, 5]
     * */
    public static void treeSetExample() {
        TreeSet<Integer> numbers = new TreeSet<>(Arrays.asList(5, 1, 5, 3));
        System.out.println(numbers);
        System.out.println("Lower than 3: " + numbers.lower(3));
        System.out.println("Higher than 3: " + numbers.higher(3));
    }

    /* Use TreeMap for sorted keys
     * @return void
     * Approach: TreeMap keeps keys in natural sorted order
     * Example: input {banana=2, apple=3} -> output {apple=3, banana=2}
     * */
    public static void treeMapExample() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("banana", 2);
        map.put("apple", 3);
        System.out.println(map);
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last key: " + map.lastKey());
    }
}
