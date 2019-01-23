package offer.problem30;

import java.util.Objects;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 30.包含min函数的栈
 * @Date 2019-01-24
 * @Time 1:31
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    //辅助栈，存放最小值
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.empty() || minStack.peek() >= stack.peek()) {
            minStack.push(node);
        }
    }

    public Integer min() {
        if (minStack.empty()) {
            return null;
        }
        return minStack.peek();
    }

    public Integer pop() {
        if (stack.empty()) {
            return null;
        }
        int num = stack.pop();
        if (!minStack.empty() && Objects.equals(num, minStack.peek())) {
            minStack.pop();
        }
        return num;
    }

    public Integer peek() {
        if (stack.empty()) {
            return null;
        }
        return stack.peek();
    }
}
