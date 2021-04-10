package com.chintan.ds;

import java.util.Stack;

public class SortStackUsingStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(40);
        stack.push(50);
        stack.push(20);

        stack.forEach(System.out::println);

        stack = getSortedStack(stack);

        System.out.println("--------------------");

        stack.forEach(System.out::println);

    }

    private static Stack<Integer> getSortedStack(Stack<Integer> stack) {
        Stack<Integer> sortedStack = new Stack<>();
        sortedStack.push(stack.pop());

        while(!stack.isEmpty()) {
            int element = stack.pop();

            int count = 0;
            while(!sortedStack.isEmpty() && element > sortedStack.peek()) {
                stack.push(sortedStack.pop());
                count++;
            }
            sortedStack.push(element);
            while (count >= 0) {
                sortedStack.push(stack.pop());
            }
        }

        return sortedStack;
    }
}
