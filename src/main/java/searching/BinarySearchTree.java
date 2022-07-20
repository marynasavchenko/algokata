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

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        return max(node.right);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;
        int keyCmp = key.compareTo(node.key);
        if (keyCmp == 0) {
            return node;
        }
        if (keyCmp < 0) return floor(node.left, key);
        Node rightNode = floor(node.right, key);
        if (rightNode != null) return rightNode;
        else return node;
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if (node == null) return null;
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) return null;
        int keyCmp = key.compareTo(node.key);
        if (keyCmp == 0) {
            return node;
        }
        if (keyCmp > 0) return ceiling(node.right, key);
        Node leftNode = ceiling(node.left, key);
        if (leftNode != null) return leftNode;
        else return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.subtreeNodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        }
        if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node nodeToDelete = node;
            // find successor
            node = min(nodeToDelete.right);
            node.left = nodeToDelete.left;
            node.right = deleteMin(nodeToDelete.right);

        }
        node.subtreeNodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }

}
