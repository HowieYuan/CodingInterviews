package leetcode.stackAndQueue.problem20;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-12-07
 * @Time 0:41
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : sc) {
            switch(c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.empty() || c != stack.pop()) {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : sc) {
            switch(c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.empty();
    }
}
