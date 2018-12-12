package leetcode.priorityQueue.problem703;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 703. 数据流中的第K大元素
 * @Date 2018-12-12
 * @Time 12:35
 */
public class KthLargest {
    private int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}
