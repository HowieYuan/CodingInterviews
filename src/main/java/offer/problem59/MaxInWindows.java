package offer.problem59;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 59.1. 滑动窗口的最大值
 * @Date 2019-02-11
 * @Time 21:15
 */
public class MaxInWindows {
    /**
     * 使用 Deque 双向队列（推荐，时间复杂度更低）
     */
    public ArrayList<Integer> solution1(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num.length == 0 || size < 1) {
            return list;
        }
        Deque<Integer> deque = new ArrayDeque<>(size);
        int n = 0;
        for(int i = 0; i < num.length; i++) {
            if(deque.size() > 0 && deque.peek() <= i - size) {
                deque.poll();
            }
            while(deque.size() > 0 && num[deque.peekLast()] < num[i]) {
                deque.pollLast();
            }
            deque.add(i);
            //当遍历到大于等于 k - 1 位置的时候，每次都需要输出一个结果值
            if(i >= size - 1) {
                list.add(num[deque.peek()]);
            }
        }
        return list;
    }

    /**
     * 使用 PriorityQueue 优先队列（大顶堆）
     */
    public ArrayList<Integer> solution2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size <= 0 || size > num.length) {
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int removeIndex = 0;
        for (int n : num) {
            queue.add(n);
            if (queue.size() >= size) {
                list.add(queue.peek());
                queue.remove(num[removeIndex++]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new MaxInWindows().solution2(new int[]{2,3,4,2,6,2,5,1}, 3));
    }
}
