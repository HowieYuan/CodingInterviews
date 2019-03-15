package leetcode.math.problem204;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 204. count-primes（计算 n 以内的素数）
 * @Date 2019-03-11
 * @Time 15:08
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                //如果这个数是质数，则标记以该数为因子的往后的数，它们都被标记为合数
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(1500000));
    }
}
