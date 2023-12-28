package com.dsa;

public class BinarySearchTree<T extends Comparable<T>> {

    // track the number of nodes
    private int nodeCount;

    // the root node
    private Node root = null;

    // the node class with left and right node and the node data
    private class Node {
        T data;
        Node left, right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return nodeCount;
    }

    // add elem in the bst return true if added and false if not
    // log(n) av and n worst
    public boolean add(T elem) {
        if (contains(elem))
            return false;
        else {
            root = add(root, elem);
            nodeCount++;
            return true;
        }
    }

    // add recursively
    private Node add(Node node, T elem) {
        // if we reatch a leaf we create a new node
        if (node == null)
            node = new Node(elem, null, null);
        else {
            if (elem.compareTo(node.data) > 0)
                node.right = add(node.right, elem);
            else
                node.left = add(node.left, elem);
        }
        return node;
    }

    public boolean remove(T elem) {
        if (contains(elem)) {

            // that return an updated root
            root = remove(root, elem);
            nodeCount--;
            return true;
        }
        return false;
    }

    private Node remove(Node node, T elem) {

        if (node == null)
            return null;
        int cmp = elem.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(node.left, elem);
        } else if (cmp > 0) {
            node.right = remove(node.right, elem);

            // if we find our node
        } else {
            if (node.left == null) {
                Node nodeRight = node.right;

                // clear memory
                node.data = null;
                node.left = node.right = null;

                return nodeRight;
            } else if (node.right == null) {
                Node nodeLeft = node.left;
                // clear memory
                node.data = null;
                node.left = node.right = null;

                return nodeLeft;
            }

            // now if a node have 2 subtree
            // we can replace with the largest on the left or the smallest
            // on the right
            else {
                // find the smallest in the right
                Node tmp = digLeft(node.right);

                // swap with the node
                node.data = tmp.data;

                // remove the last the last to avoid duplicate
                node.right = remove(node.right, tmp.data);
            }
        }
        return node;
    }

    private Node digLeft(Node node) {
        Node curr = node;
        while (curr.left != null)
            curr = curr.left;
        return curr;
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem) {
        if (node == null)
            return false;
        int cmp = elem.compareTo(node.data);

        if (cmp > 0)
            return contains(node.right, elem);
        else if (cmp < 0)
            return contains(node.left, elem);
        else
            return true;
    }
}
