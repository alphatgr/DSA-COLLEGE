class CircularQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queueArray = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Enqueue method to add an element to the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue value.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        size++;
        System.out.println("Enqueued " + value);
    }

    // Dequeue method to remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue value.");
            return -1;
        }

        int value = queueArray[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
        System.out.println("Dequeued " + value);
        return value;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display all elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queueArray[index] + " ");
        }
        System.out.println();
    }
}

public class CircularQueue {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display(); // Output: Queue elements: 10 20 30 40 50

        queue.dequeue();
        queue.dequeue();

        queue.display(); // Output: Queue elements: 30 40 50

        queue.enqueue(60);
        queue.enqueue(70);

        queue.display(); // Output: Queue elements: 30 40 50 60 70

        queue.enqueue(80); // Output: Queue is full. Cannot enqueue value.

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.display(); // Output: Queue is empty.
    }
}
