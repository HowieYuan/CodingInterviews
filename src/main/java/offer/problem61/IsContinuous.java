package offer.problem61;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 61. 扑克牌中的顺子
 * @Date 2019-02-12
 * @Time 14:20
 */
public class IsContinuous {
    public static boolean solution(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Arrays.sort(numbers);
        //大小王为0，可以看作任何数字
        int numberOfZero = 0;
        int numberOfGap = 0;
        // 统计数组中0的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            // 两个数相等，直接返回false
            if (numbers[small] == numbers[big]) {
                return false;
            }
            // 数组连续：number[big] = number[small] + 1
            numberOfGap += (numbers[big] - numbers[small] - 1);
            // 继续移动索引
            small++;
            big++;
        }
        //空缺的数是否小于大小王的个数
        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 0, 4};
        System.out.println(solution(numbers1));
        int[] numbers2 = {1, 3, 8, 0, 4};
        System.out.println(solution(numbers2));
    }
}
