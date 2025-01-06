package ss8_generic_stack_queue.exercise.ex2;

import ss7_list.ex1.MyArrayList;

public class MyArrayListQueue<E> extends MyArrayList<E> {

    public void add(E e) {
        add(size(), e);
    }

    public E peek() {
        return get(0);
    }

    public E poll() {
        E e = get(0);
        remove(0);
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
