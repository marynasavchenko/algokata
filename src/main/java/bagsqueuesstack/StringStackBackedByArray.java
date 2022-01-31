package bagsqueuesstack;

public class StringStackBackedByArray {

    private final String[] stack;
    private int size;

    public StringStackBackedByArray(int size) {
        stack = new String[size];
    }

    public void push(String element) {
        stack[size++] = element;
    }

    public String pop() {
        return stack[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}