package offer.problem31;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 31.栈的压入，弹出序列
 * @Date 2019-01-24
 * @Time 1:57
 */
public class IsPopOrder {
    /**
     * @param pushA 入栈序列
     * @param popA  出栈序列
     */
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length || pushA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        //第一步：先遍历入栈数组，如果当前入栈数组值与当前出栈数组值相等，说明是入栈并出栈的关系，则直接跳过
        //如果不相等，则入栈
        for (int num : pushA) {
            if (num == popA[popIndex]) {
                popIndex++;
            } else {
                stack.push(num);
            }
        }
        //第一步结束之后，入栈数组已经全部遍历完毕，这时候比对栈里面的数字和出栈数组的剩余数字
        //如果数值相等，则可以跳过；否则，说明不符合，则返回false
        //如果遍历完整个出栈数组都没有返回false，则说明true
        while (!stack.empty()) {
            if (stack.peek() == popA[popIndex++]) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};

        System.out.println(new IsPopOrder().isPopOrder(pushA, popA));
    }
}
