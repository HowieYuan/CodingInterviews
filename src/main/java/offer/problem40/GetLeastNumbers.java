package offer.problem40;

    import java.util.*;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 40. 最小的 k 个数
 * @Date 2019-01-27
 * @Time 21:37
 */
public class GetLeastNumbers {
    /**
     * 利用优先队列实现大顶堆
     *
     * 适合处理海量数据（nlogk）
     *
     * 当数据量较小时（低于百万级），小顶堆的做法比大顶堆稍快，
     * 原因是大顶堆的做法中有大量的判断，而小顶堆的做法只需要直接插入
     *
     * 当数据量较大时（百万级以上），小顶堆的做法的效率骤降，远远低于大顶堆的做法，
     * 这个时候时间复杂度的优势就体现出来了
     */
    public ArrayList<Integer> solution1(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 利用优先队列（小顶堆），利用小顶堆对数据进行排序
     *
     * nlogk << 时间复杂度 < nlogn
     */
    public ArrayList<Integer> solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            queue.add(num);
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 利用快排的划分思想
     *
     * O(n)
     *
     * 需要修改输入数组，不适合海量数据（因为需要占用大量内存）
     */
    public int[] solution3(int[] input, int k) {
        if (input == null || input.length<=0 || k<=0 || k>input.length) {
            return null;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k-1) {
            if (index > k-1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        int[] output = new int[k];
        System.arraycopy(input, 0, output, 0, k);
        return output;
    }

    private int partition(int[] number, int start, int end) {
        int temp = number[start];
        while (start < end) {
            while (number[end] >= temp && start < end) {
                end--;
            }
            if (start < end) {
                number[start] = number[end];
                start++;
            }
            while (number[start] < temp && start < end) {
                start++;
            }
            if (start < end) {
                number[end] = number[start];
                end--;
            }
        }
        number[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int[] array = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            Random random = new Random();
            int a = random.nextInt(9 + 1);
            array[i] = a;
        }
        long i = System.currentTimeMillis();
        System.out.println(Arrays.toString(new GetLeastNumbers().solution3(array, 10)));
        long j = System.currentTimeMillis();
        System.out.println(j - i);
    }
}
