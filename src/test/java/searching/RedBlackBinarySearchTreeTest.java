package searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackBinarySearchTreeTest {

    @Test
    void valueShouldBePresentWhenPut() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = new RedBlackBinarySearchTree<>();
        brBinarySearchTree.put(15, "AnyValue");

        assertEquals("AnyValue", brBinarySearchTree.get(15));
    }

    @Test
    void rootShouldBeBlack() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        assertEquals("28", brBinarySearchTree.root.value);
        assertFalse(brBinarySearchTree.root.color, "Root should be black");
    }

    @Test
    void leftLinkShouldBeRed() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        assertEquals("14", brBinarySearchTree.root.left.value);
        assertTrue(brBinarySearchTree.root.left.color, "Should be red");
    }

    @Test
    void shouldBeNoMoreThanOneLeftRedLinkInARow() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        assertEquals("11", brBinarySearchTree.root.left.left.value);
        assertFalse(brBinarySearchTree.root.left.left.color, "Should not be 2 red left in a row");
    }

    @Test
    void shouldDeleteMinElement() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        brBinarySearchTree.deleteMin();

        assertNull(brBinarySearchTree.get(8));
    }

    @Test
    void treeShouldBeRebalancedAfterDeleteMin() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        brBinarySearchTree.deleteMin();

        assertEquals("23", brBinarySearchTree.root.left.value);
        assertFalse(brBinarySearchTree.root.left.color, "Should be black");

        assertEquals("14", brBinarySearchTree.root.left.left.value);
        assertTrue(brBinarySearchTree.root.left.left.color, "Should be red");

        assertEquals("13", brBinarySearchTree.root.left.left.left.value);
        assertFalse(brBinarySearchTree.root.left.left.left.color, "Should be black ");

        assertEquals("25", brBinarySearchTree.root.left.right.value);
        assertFalse(brBinarySearchTree.root.left.right.color, "Should be black");
    }

    @Test
    void shouldDeleteElementByKey() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        brBinarySearchTree.delete(32);

        assertNull(brBinarySearchTree.get(32));
    }

    @Test
    void treeShouldBeRebalancedAfterDelete() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = createRedBlackBST();

        brBinarySearchTree.delete(32);
        assertEquals("14", brBinarySearchTree.root.value);

        assertEquals("28", brBinarySearchTree.root.right.value);
        assertFalse(brBinarySearchTree.root.right.color, "Should be black");

        assertEquals("23", brBinarySearchTree.root.right.left.value);
        assertTrue(brBinarySearchTree.root.right.left.color, "Should be red");

        assertEquals("33", brBinarySearchTree.root.right.right.left.value);
        assertTrue(brBinarySearchTree.root.right.right.left.color, "Should be red");
    }

    private RedBlackBinarySearchTree<Integer, String> createRedBlackBST() {
        RedBlackBinarySearchTree<Integer, String> brBinarySearchTree = new RedBlackBinarySearchTree<>();
        brBinarySearchTree.put(8, "8");
        brBinarySearchTree.put(11, "11");
        brBinarySearchTree.put(14, "14");
        brBinarySearchTree.put(13, "13");
        brBinarySearchTree.put(16, "16");
        brBinarySearchTree.put(23, "23");
        brBinarySearchTree.put(25, "25");
        brBinarySearchTree.put(28, "28");
        brBinarySearchTree.put(32, "32");
        brBinarySearchTree.put(33, "33");
        brBinarySearchTree.put(36, "36");
        return brBinarySearchTree;
    }
}