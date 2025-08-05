import java.util.*;
import java.lang.*;

class Stack {
    public final int max = 4;
    public int[] arr = new int[max];
    public int tos = -1;

    public void push(int data) {
        if (tos == max - 1) {
            System.out.println("Stack is overflowed");
            return;
        }
        tos++;
        arr[tos] = data;
        System.out.println("Pushed = " + data);
    }

    public void pop() {
        if (tos == -1) {
            System.out.println("Stack is underflowed");
            return;
        }
        System.out.println("Popped = " + arr[tos]);
        tos--;
    }

    public void display() {
        if (tos == -1) {
            System.out.println("Stack is empty");
            return;
        }
    }

    public void peep() {
        System.out.println("Top Element=" + arr[tos]);
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);
        stack.push(77);
        stack.push(88);
        stack.push(99);
        stack.pop();
        stack.pop();
        stack.peep();
    }

}
