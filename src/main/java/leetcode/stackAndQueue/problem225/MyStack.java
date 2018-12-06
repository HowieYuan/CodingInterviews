package leetcode.stackAndQueue.problem225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-12-07
 * @Time 2:07
 */
class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {
    }

    public void push(int x) {
        q.add(x);
        for(int i = 1; i < q.size(); i ++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    // Removes the element on top of the stack.
    public int pop() {
        return q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}