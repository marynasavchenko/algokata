package bagsqueuesstack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStackBackedByArrayTest {
    @Test
    void shouldGetFirstElementInTheStack() {
        StringStackBackedByArray stack = new StringStackBackedByArray(10);
        stack.push("first");
        stack.push("second");
        stack.push("third");

        String element = stack.pop();

        assertEquals("third", element);
    }

    @Test
    void shouldReturnStackSize() {
        StringStackBackedByArray stack = new StringStackBackedByArray(10);
        stack.push("first");
        stack.push("second");
        stack.push("third");

        assertEquals(3, stack.size());
    }

    @Test
    void stackShouldBeEmpty() {
        StringStackBackedByArray stack = new StringStackBackedByArray(10);

        assertTrue(stack.isEmpty());
    }

    @Test
    void stackShouldBeEmptyWhenElementsWereRemoved() {
        StringStackBackedByArray stack = new StringStackBackedByArray(10);
        stack.push("first");
        stack.push("second");

        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
    }
}