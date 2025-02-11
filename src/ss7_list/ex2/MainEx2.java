package ss7_list.ex2;

public class MainEx2 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        System.out.println("List init: " + list);

        list.addLast(40);
        list.addLast(50);

        list.add(2, 25);
        System.out.println("List after add(2, 25): " + list);

        list.removeFirst();
        System.out.println("List after removeFirst: " + list);

        list.removeLast();
        System.out.println("List after removeLast: " + list);

        list.remove(2);
        System.out.println("List after remove(2): " + list);

        System.out.println("First element: " + list.getFirst());

        System.out.println("Last element: " + list.getLast());

        System.out.println("Element at index 1: " + list.get(1));

        list.set(0, 15);
        System.out.println("List after set(0, 15): " + list);

        System.out.println("Index of element 20: " + list.indexOf(20));

        System.out.println("Last index of element 25: " + list.lastIndexOf(25));
    }
}
