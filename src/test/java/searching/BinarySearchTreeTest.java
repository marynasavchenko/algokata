package searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BinarySearchTreeTest {

    public static final String LEFT_VALUE = "leftValue";
    public static final String ROOT_VALUE = "rootValue";
    public static final String RIGHT_VALUE = "rightValue";
    public static final int ROOT_KEY = 6;
    public static final int LEFT_KEY = 4;
    public static final int RIGHT_KEY = 8;
    public static final int SECOND_LEFT_KEY = 7;
    public static final String SECOND_LEFT_VALUE = "2LeftValue";
    public static final int NON_PRESENT_KEY = 12;

    @Test
    void leftLinkShouldPointToItemWithSmallerKey() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(LEFT_KEY, LEFT_VALUE);

        assertEquals(LEFT_KEY, bst.root.left.key);
        assertEquals(LEFT_VALUE, bst.root.left.value);
    }

    @Test
    void rightLinkShouldPointToItemWithLargerKey() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(RIGHT_KEY, RIGHT_VALUE);

        assertEquals(RIGHT_KEY, bst.root.right.key);
        assertEquals(RIGHT_VALUE, bst.root.right.value);
    }

    @Test
    void secondLeftLinkShouldPointToItemWithSmallerKey() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(RIGHT_KEY, RIGHT_VALUE);
        bst.put(SECOND_LEFT_KEY, SECOND_LEFT_VALUE);

        assertEquals(SECOND_LEFT_KEY, bst.root.right.left.key);
        assertEquals(SECOND_LEFT_VALUE, bst.root.right.left.value);
    }

    @Test
    void shouldReturnCorrectSizeOfBST() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(LEFT_KEY, LEFT_VALUE);
        bst.put(RIGHT_KEY, RIGHT_VALUE);

        assertEquals(3, bst.size());
    }

    @Test
    void shouldReturnNullWhenKeyIsNotPresent() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(RIGHT_KEY, RIGHT_VALUE);
        bst.put(SECOND_LEFT_KEY, SECOND_LEFT_VALUE);

        assertNull(bst.get(NON_PRESENT_KEY));
    }

    @Test
    void shouldGetRightValueForKey() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(ROOT_KEY, ROOT_VALUE);
        bst.put(RIGHT_KEY, RIGHT_VALUE);
        bst.put(SECOND_LEFT_KEY, SECOND_LEFT_VALUE);

        assertEquals(RIGHT_VALUE, bst.get(RIGHT_KEY));
    }

    @Test
    void shouldReturnMinKeyInBST() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(23, "value1");
        bst.put(15, "value2");
        bst.put(56, "value3");
        bst.put(7, "value4");
        bst.put(71, "value5");

        assertEquals(7, bst.min());
    }

    @Test
    void shouldReturnMaxKey() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(23, "value1");
        bst.put(15, "value2");
        bst.put(56, "value3");
        bst.put(7, "value4");

        assertEquals(56, bst.max());
    }

    @Test
    void shouldReturnFloorWhenGivenKeyIsEqual() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(23, "value1");
        bst.put(14, "value2");
        bst.put(32, "value3");

        assertEquals(14, bst.floor(14));
    }

    @Test
    void shouldReturnFloorWhenGivenKeyIsLarger() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(23, "value1");
        bst.put(14, "value2");
        bst.put(32, "value3");
        bst.put(36, "value4");
        bst.put(33, "value5");

        assertEquals(33, bst.floor(34));
    }

    @Test
    void shouldReturnCeilingWhenGivenKeyIsSmaller() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(23, "value1");
        bst.put(14, "value2");
        bst.put(32, "value3");
        bst.put(36, "value4");
        bst.put(33, "value5");

        assertEquals(36, bst.ceiling(34));
    }
}