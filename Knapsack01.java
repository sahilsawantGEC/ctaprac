
//Approximation algorithm for Knapsack01
import java.util.*;

public class Knapsack01 {
    static int Knapsack(int[] val, int[] wt, int n, int W) {
        int[] dp = new int[W + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w) {
                    dp[w] = Math.max(dp[w], dp[w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of items:");
        int size = input.nextInt();
        int[] profit = new int[size];
        int[] weight = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the profit of item " + i);
            profit[i] = input.nextInt();
            System.out.println("Enter the weight of item " + i);
            weight[i] = input.nextInt();
        }
        System.out.println("Enter the Knapsack weight");
        int W = input.nextInt();
        System.out.print("The maximum profit is:" + Knapsack(profit, weight, size, W));
        input.close();
    }

}
 