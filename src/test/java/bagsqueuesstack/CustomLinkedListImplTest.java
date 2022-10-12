package bagsqueuesstack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListImplTest {
    private final CustomLinkedListImpl<Integer> linkedList = new CustomLinkedListImpl<>();

    @Test
    void shouldAddElementToLinkedList() {
        linkedList.add(25);
        assertEquals(25, linkedList.iterator().next());

        assertEquals(1, linkedList.size());
    }

    @Test
    void shouldAddSeveralElementToLinkedList() {
        linkedList.add(25);
        linkedList.add(26);
        linkedList.add(27);

        assertEquals(27, linkedList.iterator().next());
        assertEquals(3, linkedList.size());
    }

    @Test
    void shouldRemoveFromHead() {
        linkedList.add(25);
        linkedList.add(26);
        linkedList.add(27);

        linkedList.removeFromHead();

        assertEquals(27, linkedList.iterator().next());
        assertEquals(3, linkedList.size());
    }

    @Test
    void shouldRevertLinkedList() {
        linkedList.add(25);
        linkedList.add(26);
        linkedList.add(27);
        linkedList.add(28);

        linkedList.reverseList();

        assertEquals(25, linkedList.iterator().next());
    }

}