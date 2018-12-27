package leetcode.stackAndQueue.problem232;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 232. 栈实现队列
 * @Date 2018-12-07
 * @Time 1:21
 */
public class MyQueue {
    private Stack input;
    private Stack output;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.input = new Stack();
        this.output = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return (int) output.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(output.empty()) {
            while(!input.empty()) {
                output.push(input.pop());
            }
        }
        return (int) output.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return output.empty() && input.empty();
    }
}
