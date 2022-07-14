package searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    protected Node root;

    protected class Node {
        protected Key key;
        protected Value value;
        protected Node right;
        protected Node left;
        protected int subtreeNodeNumber;

        public Node(Key key, Value value, int subtreeNodeNumber) {
            this.key = key;
            this.value = value;
            this.subtreeNodeNumber = subtreeNodeNumber;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.subtreeNodeNumber;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int keyCmp = key.compareTo(node.key);
        if (keyCmp < 0) {
            return get(node.left, key);
        }
        if (keyCmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);

    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.subtreeNodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }
}
