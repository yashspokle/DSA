import java.util.Scanner;

public class Stack_Scanner {

    static final int PUSH = 1;
    static final int POP = 2;
    static final int PEEK = 3;
    static final int DISPLAY = 4;
    static final int EXIT = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the maximum size of the stack: ");
        int maxSize = sc.nextInt();
        int[] stack = new int[maxSize];
        int top = -1; // Top of Stack index

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println(PUSH + ". Push");
            System.out.println(POP + ". Pop");
            System.out.println(PEEK + ". Peek");
            System.out.println(DISPLAY + ". Display");
            System.out.println(EXIT + ". Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case PUSH:
                    top = push(sc, stack, top, maxSize);
                    break;

                case POP:
                    top = pop(stack, top);
                    break;

                case PEEK:
                    peek(stack, top);
                    break;

                case DISPLAY:
                    display(stack, top);
                    break;

                case EXIT:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Push operation
    static int push(Scanner sc, int[] stack, int top, int maxSize) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push.");
        } else {
            System.out.print("Enter value to push: ");
            int value = sc.nextInt();
            stack[++top] = value;
            System.out.println("Pushed: " + value);
        }
        return top;
    }

    // Pop operation
    static int pop(int[] stack, int top) {
        if (top == -1) {
            System.out.println("Stack Underflow! Nothing to pop.");
        } else {
            System.out.println("Popped: " + stack[top]);
            top--;
        }
        return top;
    }

    // Peek operation
    static void peek(int[] stack, int top) {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element: " + stack[top]);
        }
    }

    // Display stack elements
    static void display(int[] stack, int top) {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
