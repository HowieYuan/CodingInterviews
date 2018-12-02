package offer.problem09;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 9.用两个栈实现队列
 * @Date 2018-11-19
 * @Time 12:29
 */
public class Nine {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        return stack2.pop();
    }
}
