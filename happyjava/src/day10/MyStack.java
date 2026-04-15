package day10;

import java.util.ArrayList;

public class MyStack<T> {
    private final ArrayList<T> stack;
    private final int capacity;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.stack = new ArrayList<>(capacity);
    }

    public void push(T value) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack.add(value);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");

        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull() {
        return stack.size() == capacity;
    }

    public int size() {
        return stack.size();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>(3);
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
//        myStack.push("d");
        System.out.println(myStack);

        System.out.println("Top item: " + myStack.peek());
        System.out.println("Pop item: " + myStack.pop());
        System.out.println("Current size: " + myStack.size());
        myStack.pop();
        System.out.println("Current size: " + myStack.size());
        myStack.pop();
        System.out.println("Current size: " + myStack.size());

        System.out.println(myStack);
//        myStack.pop();
    }
}