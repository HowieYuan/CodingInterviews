package offer.problem17;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description p114  17. 打印从1到最大的n位数
 * @Date 2018-11-29
 * @Time 17:42
 */
public class ToMax {
    /**
     * 递归方法
     * <p>
     * 陷阱：当 n 的值很大时，用整型甚至长整型可能溢出，因此要使用其他方法
     *
     * @param n 控制数字
     */
    private static void printlToMaxOfDiguts1(int n) {
        if (n <= 0) {
            throw new RuntimeException("非法输入！");
        }
        // 分配空间
        int[] number = new int[n];
        // 从第0位开始赋值
        printlToMaxOfDigutsRecursively(number, 0);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param number 给定数组
     * @param n      当前控制索引
     */
    private static void printlToMaxOfDigutsRecursively(int[] number, int n) {
        int length = 10;
        if (n != number.length) {
            for (int i = 0; i < length; i++) {
                number[n] = i;
                // 递归调用，给第n+1位赋值
                printlToMaxOfDigutsRecursively(number, n + 1);
            }
        } else {
            // 当所有空间赋值完毕执行输出
            printNums(number);
        }
    }


    /**
     * 迭代
     */
    public static void printToMaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] nums = new int[n];
        while (getNums(nums)) {
            printNums(nums);
        }
    }

    private static boolean getNums(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 9) {
                if (i == 0) {
                    return false;
                }
                nums[i] = 0;
                continue;
            }
            nums[i]++;
            break;
        }
        return true;
    }

    private static void printNums(int[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == 0) {
            index++;
        }
        // 从第一个非0的元素开始输出
        for (int i = index; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        // 递归调用
//        printlToMaxOfDiguts1(3);
        System.out.println("==========");
        // 非递归调用
        printlToMaxOfDiguts1(3);
    }
}