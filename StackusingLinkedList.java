class Node {
    int data;
    Node next;
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Pushes an element onto the stack
    public void push(int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.next = top;
        top = newNode;
    }

    // Pops an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }

    // Peeks at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        } else {
            return top.data;
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Displays all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            Node temp = top;
            System.out.print("Stack elements: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}

public class StackusingLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 50

        stack.display(); // Output: Stack elements: 50 40 30 20 10

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // Output: 50 40 30 20 10

        stack.display(); // Output: Stack is empty.
    }
}
