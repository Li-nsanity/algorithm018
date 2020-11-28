package Leetcode;

import java.util.Arrays;

public class Q322 {
    public static void main(String[] args) {
        int[] coins = new int[]{2, 7, 3};
        int amount = 100;
        int result = coinChange(coins, amount);
        System.out.println("总额为"+amount+"元的最少钱币数量为："+result);
    }

    /*
     * @Description: 给定总金额和可能的钱币面额，找出钱币最少数量的方式。
     * @param coins-钱币组合，amount-总金额
     * @return int-钱币最少数量
     */
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;//初始值为不能到达
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}
