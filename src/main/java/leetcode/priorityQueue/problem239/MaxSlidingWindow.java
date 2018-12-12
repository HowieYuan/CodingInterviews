package leetcode.priorityQueue.problem239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 239. Sliding Window Maximum  滑动窗口最大值
 * @Date 2018-12-12
 * @Time 15:25
 */
public class MaxSlidingWindow {
    /**
     * 使用 Deque 双向队列
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k < 1) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayDeque<>(k);
        int[] results = new int[nums.length - k + 1];
        int n = 0;
        for(int i = 0; i < nums.length; i++) {
            if(deque.size() > 0 && deque.peek() <= i - k) {
                deque.poll();
            }
            while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            if(i >= k - 1) {
                results[n++] = nums[deque.peek()];
            }
        }
        return results;
    }

    /**
     * 使用 PriorityQueue 优先队列（大顶堆）
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] results = new int[nums.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (Integer a, Integer b) -> b - a);
        int n = 0;
        for (int num : nums) {
            queue.add(num);
            if (queue.size() >= k) {
                results[n++] = queue.peek();
                queue.remove(nums[n - 1]);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
