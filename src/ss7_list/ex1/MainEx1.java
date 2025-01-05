package ss7_list.ex1;

public class MainEx1 {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(30);
        list.add(30);

        System.out.println("List init: " + list.toString());

        list.add(2, 25);
        System.out.println("List after add(2, 25): " + list.toString());

        list.set(3, 35);
        System.out.println("List after set(3, 35): " + list.toString());

        System.out.println("Element at index 4: " + list.get(4));

        int elementToFind = 30;
        int firstIndexOfElement = list.indexOf(elementToFind);
        if (firstIndexOfElement != -1) {
            System.out.printf("First index of element %d: %d\n", elementToFind, firstIndexOfElement);
        } else {
            System.out.printf("Element %d not found in list\n", elementToFind);
        }

        int lastIndexOfElement = list.lastIndexOf(elementToFind);
        if (lastIndexOfElement != -1) {
            System.out.printf("Last index of element %d: %d\n", elementToFind, lastIndexOfElement);
        } else {
            System.out.printf("Element %d not found in list\n", elementToFind);
        }

        list.remove(1);
        System.out.println("List after remove(1): " + list.toString());

        list.removeElement(30);
        System.out.println("List after removeElement(30): " + list.toString());
    }
}
