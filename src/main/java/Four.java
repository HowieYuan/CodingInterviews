/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description P44 二维数组中的查找
 * @Date 2018-09-21
 * @Time 16:21
 */
public class Four {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3, 4},
                {2, 3, 5, 7},
                {3, 11, 12, 13},
                {10, 14, 15, 20}
        };

        findNum2(nums, 20);

    }

    /**
     * 牛客网
     */
    public boolean find(int target, int [][] array) {
        /*
            1 2 3 4
            2 3 6 7
            3 4 8 9
        */
        if(array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0, j = array[0].length - 1;
        int num = array[i][j];
        while(target != num) {
            if(target < num) {
                if(j == 0) {
                    break;
                }
                num = array[i][--j];
            } else {
                if(i == array.length - 1) {
                    break;
                }
                num = array[++i][j];
            }
        }
        return target == num;
    }

    /**
     * 选择右上角数字进行比对，逐步减少范围
     */
    private static void findNum1(int[][] nums, int target) {
        int row = 0;
        int column = nums[0].length - 1;
        while (nums[row][column] != target) {
            if (nums[row][column] > target) {
                column--;
                if (column < 0) {
                    System.out.println("目标数字不存在");
                    return;
                }
            } else {
                row++;
                if (row >= nums.length) {
                    System.out.println("目标数字不存在");
                    return;
                }
            }
        }
        System.out.println(row + " " + column);
    }

    /**
     * 暴力遍历
     */
    private static void findNum2(int[][] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i][0] > target) {
                System.out.println("目标数字不存在");
                break;
            }
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] > target) {
                    continue;
                }
                if (nums[i][j] == target) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
