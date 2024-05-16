package org.SpringTask.Bean;


import org.springframework.stereotype.*;

@Component
public class Demo_Stack {
    private int[] stackArray;
    private int top;
    private int capacity;


    public Demo_Stack() {

    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        stackArray = new int[capacity];
        top = -1;
    }

    public void push(int number) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element " + number);
        } else {
            stackArray[++top] = number;
//            System.out.println("Pushed element " + number);
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            throw new RuntimeException("Stack is empty. Cannot pop element.");
//            return -1 ; // Or throw an exception
        } else {
            int poppedElement = stackArray[top--];
            System.out.println("Popped element " + poppedElement);
            return poppedElement;
        }
    }

    public void removeAtIndex(int index) {
        System.out.println("Index Count Start from 0");
        if (index < 0 || index > top) {
            System.out.println("Invalid index. Index should be between 0 and " + top);
        } else {
            int removedElement = stackArray[index];
            for (int i = index; i < top; i++) {
                stackArray[i] = stackArray[i + 1];
            }
            top--;

            System.out.println("Removed element at index " + index + ": " + removedElement);
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == capacity - 1);
    }

    public void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}
