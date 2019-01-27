package offer.problem41;

import java.util.*;

public class Median {
    /**
     * 数值总量
     */
    private int sum = 0;
    /**
     * 大顶堆，存放左半部分数据
     */
    private Queue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    /**
     * 小顶堆，存放右半部分数据
     */
    private Queue<Integer> right = new PriorityQueue<>();

    public void insert(Integer num) {
        if (sum == 0) {
            left.add(num);
        } else if (num > left.peek()) {
            right.add(num);
        } else {
            left.add(num);
        }
        sum++;
        if (right.size() - left.size() == 1) {
            left.add(right.poll());
        } else if (left.size() - right.size() == 2) {
            right.add(left.poll());
        }
    }

    public Double getMedian() {
        if (sum % 2 == 0) {
            return ((double)left.peek() + (double)right.peek()) / 2;
        } else {
            return (double)left.peek();
        }
    }

    public static void main(String[] args) {
        Median median = new Median();
        median.insert(5);
        System.out.println(median.getMedian());
        median.insert(2);
        System.out.println(median.getMedian());
        median.insert(3);
        System.out.println(median.getMedian());
        median.insert(4);
        System.out.println(median.getMedian());
    }
}