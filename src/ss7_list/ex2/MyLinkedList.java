package ss7_list.ex2;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(int element) {
        if (size == 0) {
            head = tail = new Node(element);
        } else {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node current = head;
        while (current != null) {
            result.append(current.data).append(" ");
            current = current.next;
        }
        return result.toString();
    }

    public void addLast(int element) {
        if (size == 0) {
            head = tail = new Node(element);
        } else {
            Node newNode = new Node(element);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public int removeFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Index: 0, Size: 0");
        }
        Node current = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return current.data;
    }

    public int removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Index: 0, Size: 0");
        }
        Node current = head;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        return current.data;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public int getFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        return head.data;
    }

    public int getLast() {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        return tail.data;
    }

    public int get(int index) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    public void set(int index, int element) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public int indexOf(int element) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == element)
                return i;
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(int element) {
        if (head == null) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        Node current = head;
        for (int i = size - 1; i >= 0; i--) {
            if (current.data == element)
                return i;
            current = current.next;
        }
        return -1;
    }
}
