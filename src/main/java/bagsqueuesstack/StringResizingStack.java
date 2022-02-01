package bagsqueuesstack;

public class StringResizingStack {
    private String[] stack = new String[1];
    private int size;

    public void push(String element) {
        if (size == stack.length) {
            resize(size * 2);
        }
        stack[size++] = element;
    }

    public String pop() {
        String element = stack[--size];
        stack[size] = null;
        if (size > 0 && size == stack.length / 4) {
            resize(size / 2);
        }
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newSize) {
        String[] newArray = new String[newSize];
        for (int i = 0; i < size; i++) {
            newArray[i] = stack[i];
        }
        stack = newArray;
    }
}
