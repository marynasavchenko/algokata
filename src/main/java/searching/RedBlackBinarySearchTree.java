package searching;

public class RedBlackBinarySearchTree<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    protected Node root;

    protected class Node {
        protected Key key;
        protected Value value;
        protected Node right;
        protected Node left;
        protected int nodeNumber;
        protected boolean color;

        protected Node(Key key, Value value, int nodeNumber, boolean color) {
            this.key = key;
            this.value = value;
            this.nodeNumber = nodeNumber;
            this.color = color;
        }

    }

    protected boolean isRed(Node node) {
        if (node == null) {
            return false;
        }
        return node.color == RED;
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

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.nodeNumber;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;

    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1, RED);
        }
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            node.left = put(node.left, key, value);
        } else if (compare > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node = balanceBST(node);
        node.nodeNumber = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node balanceBST(Node node) {
        if (isRed(node.right) && !isRed(node.left)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);
        return node;
    }

    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (root != null) root.color = BLACK;
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return null;

        if (!isRed(node.left) && !isRed(node.left.left))
            node = moveRedLeft(node);

        node.left = deleteMin(node.left);
        return balanceBST(node);
    }

    public void delete(Key key) {
        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = delete(root, key);
        if (root != null) root.color = BLACK;
    }

    private Node delete(Node node, Key key) {
        if (key.compareTo(node.key) < 0) {
            if (!isRed(node.left) && !isRed(node.left.left))
                node = moveRedLeft(node);
            node.left = delete(node.left, key);
        } else {
            if (isRed(node.left))
                node = rotateRight(node);
            if (key.compareTo(node.key) == 0 && (node.right == null))
                return null;
            if (!isRed(node.right) && !isRed(node.right.left))
                node = moveRedRight(node);
            if (key.compareTo(node.key) == 0) {
                Node x = min(node.right);
                node.key = x.key;
                node.value = x.value;
                node.right = deleteMin(node.right);
            } else node.right = delete(node.right, key);
        }
        return balanceBST(node);
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    private Node moveRedLeft(Node node) {
        flipColors(node);
        if (isRed(node.right.left)) {
            node.right = rotateRight(node.right);
            node = rotateLeft(node);
            flipColors(node);
        }
        return node;
    }

    private Node moveRedRight(Node node) {
        flipColors(node);
        if (isRed(node.left.left)) {
            node = rotateRight(node);
            flipColors(node);
        }
        return node;
    }


    private Node rotateLeft(Node node) {
        Node nodeToRotate = node.right;
        node.right = nodeToRotate.left;
        nodeToRotate.left = node;
        nodeToRotate.color = node.color;
        node.color = RED;
        nodeToRotate.nodeNumber = node.nodeNumber;
        node.nodeNumber = 1 + size(node.left) + size(node.right);
        return nodeToRotate;
    }

    private Node rotateRight(Node node) {
        Node nodeToRotate = node.left;
        node.left = nodeToRotate.right;
        nodeToRotate.right = node;
        nodeToRotate.color = node.color;
        node.color = RED;
        nodeToRotate.nodeNumber = node.nodeNumber;
        node.nodeNumber = 1 + size(node.left) + size(node.right);
        return nodeToRotate;
    }

    private void flipColors(Node node) {
        node.color = !node.color;
        node.right.color = !node.right.color;
        node.left.color = !node.left.color;
    }

}
