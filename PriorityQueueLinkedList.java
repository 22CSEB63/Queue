class Node {
    int value;
    int priority;
    Node next;

    public Node(int priority, int value) {
        this.priority = priority;
        this.value = value;
        this.next = null;
    }
}

class PriorityQueueLinkedList {
    private Node front;

    public PriorityQueueLinkedList() {
        front = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int priority, int value) {
        Node newNode = new Node(priority, value);
        if (isEmpty() || front.priority > priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int value = front.value;
        front = front.next;
        return value;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        while (temp != null) {
            System.out.print("| [" + temp.priority + ", " + temp.value + "] | ");
            temp = temp.next;
        }
        System.out.println("Peek => " + front.value);
    }

    public static void main(String[] args) {
        PriorityQueueLinkedList pq = new PriorityQueueLinkedList();
        pq.enqueue(5, 1);
        pq.printQueue();
        pq.enqueue(4, 2);
        pq.printQueue();
        pq.enqueue(6, 3);
        pq.printQueue();
        System.out.println("Dequeued: " + pq.dequeue());
        pq.printQueue();
    }
}
