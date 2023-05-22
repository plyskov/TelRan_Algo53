package lesson03_20230522;

public class QueueOfStrings {

    private Node tail;
    private Node head;
    private int size;

    private class Node {
        Node prev;
        String value;

        public Node(String value) {
            this.value = value;
        }
    }

    public QueueOfStrings() {
        size = 0;
        tail = null;
    }

    public void enqueue(String value){
        Node n = new Node(value);
        if (size == 0){
            tail = n;
            head = n;
        } else {
            head.prev = n;
            head = n;
        }
        size++;
    }

    public String dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");

        String value = tail.value;
        tail = tail.prev;
        if (tail == null) {
            head = null;
            head = null;
        }
        size--;
        return value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        QueueOfStrings q = new QueueOfStrings();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");


        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }

}
