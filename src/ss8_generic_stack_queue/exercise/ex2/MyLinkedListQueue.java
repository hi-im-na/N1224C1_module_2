package ss8_generic_stack_queue.exercise.ex2;

import ss7_list.ex2.MyLinkedList;

/**
 * Implement a queue using linked list
 * head is front of queue, bc no need to traverse to the end of list
 * @param <E>
 */
public class MyLinkedListQueue<E> extends MyLinkedList<E> {

    public void add(E e) {
        addLast(e);
    }

    public E peek() {
        return getFirst();
    }

    public E poll() {
        E e = getFirst();
        removeFirst();
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
