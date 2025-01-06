package ss8_generic_stack_queue.exercise.ex1;

import ss7_list.ex2.MyLinkedList;

/**
 * Implement a stack using linked list
 * head is top of stack, bc no need to traverse to the end of list
 * @param <E>
 */
public class MyLinkedListStack<E> extends MyLinkedList<E> {

    public void push(E e) {
        addFirst(e);
    }

    public E peek() {
        return getFirst();
    }

    public E pop() {
        E e = getFirst();
        removeFirst();
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
