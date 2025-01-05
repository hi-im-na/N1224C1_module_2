package ss7_list.ex1;

public class MyArrayList {
    private int size = 0;
    private static int capacity = 10;
    private int[] arr = new int[capacity];

    public MyArrayList() {
    }

    public void add(int element) {
        upsizeIfArrIsFull();
        arr[size] = element;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(arr[i]).append(" ");
        }
        return result.toString();
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        upsizeIfArrIsFull();

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
        size++;
    }

    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        arr[index] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return arr[index];
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    public void removeElement(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                remove(i);
            }
        }
    }

    private void upsizeIfArrIsFull() {
        if (size == capacity) {
            capacity *= 1.5;
            int[] newElements = new int[capacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = arr[i];
            }
            arr = newElements;
        }
    }
}
