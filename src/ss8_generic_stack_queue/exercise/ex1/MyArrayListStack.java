package ss8_generic_stack_queue.exercise.ex1;

import ss7_list.ex1.MyArrayList;

public class MyArrayListStack<E> extends MyArrayList<E> {
    public void push(E e) {
        add(e);
    }

    public E peek() {
        if (size() == 0) {
            return null;
        }
        return get(size() - 1);
    }

    public E pop() {
        if (size() == 0) {
            return null;
        }
        E e = get(size() - 1);
        remove(size() - 1);
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
