package offer.problem62;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 62. 圆圈中最后剩下的数字(约瑟夫环问题)
 * @Date 2019-02-12
 * @Time 14:35
 */
public class LastRemainingInCircle {
    /**
     * @param n 环型数组元素个数
     * @param m 计数
     */
    public static int solution1(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        //链表
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            //环形链表计算下一个点
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    /**
     * 从 0 到（n-1）的环型数组中，依次删除第 m 个数，直到最后一个数
     * 采用数学分析法
     *
     * @param n 环型数组元素个数
     * @param m 计数
     * @return 数组最后一个数
     */
    private static int solution2(int n, int m) {
        if (m < 1 || n < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            // 重要公式
            last = (last + m) % i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(solution1(5, 3));
    }
}
