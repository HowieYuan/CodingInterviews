package offer.problem63;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 63. 股票最大利润
 * @Date 2019-02-12
 * @Time 15:56
 */
public class StockMaxProfit {
    public static int solution(int[] prices) {
        if (prices.length <= 1) {
            return -1;
        }
        //最低买入价
        int minBuy = prices[0];
        //最大收益
        int maxProfit = prices[1] - minBuy;
        for (int i = 2; i < prices.length; i++) {
            //计算当前最低买入价
            if (prices[i - 1] < minBuy) {
                minBuy = prices[i - 1];
            }
            //计算当前最大收益
            int currentProfit = prices[i] - minBuy;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //11
        System.out.println(solution(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));

    }
}
