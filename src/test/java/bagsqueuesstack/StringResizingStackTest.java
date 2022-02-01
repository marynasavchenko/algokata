package bagsqueuesstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringResizingStackTest {
    @Test
    void shouldGetFirstElementInTheStack() {
        StringResizingStack stack = new StringResizingStack();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        String element = stack.pop();

        assertEquals("third", element);
    }

    @Test
    void shouldReturnStackSize() {
        StringResizingStack stack = new StringResizingStack();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        assertEquals(3, stack.size());
    }

    @Test
    void stackShouldBeEmpty() {
        StringResizingStack stack = new StringResizingStack();

        assertTrue(stack.isEmpty());
    }

    @Test
    void stackShouldBeEmptyWhenElementsWereRemoved() {
        StringResizingStack stack = new StringResizingStack();
        stack.push("first");
        stack.push("second");

        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
    }

}