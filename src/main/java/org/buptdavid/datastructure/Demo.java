package org.buptdavid.datastructure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author stan
 * @date 2025/2/26
 */
public class Demo {

    public static void main(String[] args) {


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);


        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        System.out.println(deque);

    }

}
