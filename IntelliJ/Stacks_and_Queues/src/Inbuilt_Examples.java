import java.util.*;

public class Inbuilt_Examples {
    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        stack.push(34);
//        stack.push(43);
//        stack.push(53);
//        stack.push(63);
//
//
//        System.out.println(stack.pop());//firstly, the last element that was inserted will be removed
//        System.out.println(stack.pop());//53
//        System.out.println(stack.pop());//43
//        System.out.println(stack.pop());//34
//        System.out.println(stack.pop());

//        int[] arr = new int[2];

        //Queue Data Structure can be implemented using LinkedLists
        //as we are only given with the interface for Queue
//        Queue<Integer> q = new LinkedList<>();
//        q.add(45);
//        q.add(63);
//        q.add(64);
//        q.add(65);
//        q.add(67);
//
//        System.out.println(q.peek()); //returns the head of the LL
//        System.out.println(q.remove()); //deletion from head
//        System.out.println(q.remove()); //deletion from head

        //DeQue -> Doubly ended Queue -> Insert and delete from both the sides
        Deque<Integer> deque = new ArrayDeque<>();
        // It is a resizeable array that allows you to add or remove elements from
        // both ends of the queue. This makes it a good choice for scenarios where you need to
        // perform many add and remove operations.

        deque.add(89);
        deque.add(89);
        deque.addLast(45);
        deque.addFirst(432);

    }
}