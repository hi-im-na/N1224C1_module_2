package ss8_generic_stack_queue.exercise.ex1;

public class MainEx1 {
    public static void main(String[] args) {
        MyLinkedListStack<Integer> lls = new MyLinkedListStack<>();
        MyArrayListStack<Integer> als = new MyArrayListStack<>();

        System.out.println("------LinkedListStack-----");
        lls.push(10);
        lls.push(20);
        lls.push(30);
        System.out.println("Stack: " + lls);
        System.out.println("First element: " + lls.peek());
        System.out.println("Pop element: " + lls.pop());
        System.out.println("Is stack empty? " + lls.isEmpty());
        System.out.println("size of stack: " + lls.size());

        System.out.println();

        System.out.println("------ArrayListStack-----");
        als.push(10);
        als.push(20);
        als.push(30);
        System.out.println("Stack: " + als);
        System.out.println("First element: " + als.peek());
        System.out.println("Pop element: " + als.pop());
        System.out.println("Is stack empty? " + als.isEmpty());
        System.out.println("size of stack: " + als.size());
    }
}
