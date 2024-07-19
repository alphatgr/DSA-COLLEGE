import java.util.EmptyStackException;

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Pushes an element onto the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push value.");
        } else {
            stackArray[++top] = value;
        }
    }

    // Pops an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    // Peeks at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Checks if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Returns the size of the stack
    public int size() {
        return top + 1;
    }

    // Displays all elements in the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackusingArray {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 50

        stack.display(); // Output: Stack elements: 10 20 30 40 50

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // Output: 50 40 30 20 10

        stack.display(); // Output: Stack is empty.
    }
}
