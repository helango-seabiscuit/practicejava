package com.hemalatha.interview.arrays;

import java.util.PriorityQueue;
import java.util.Random;

public class BuySellStockHard {

    public static void main(String[] args) {
        BuySellStockHard bs = new BuySellStockHard();
        System.out.println(bs.maxProfit(new int[]{7,1,5,3,6,4}));
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }
    public int maxProfit(int[] prices) {
      int[] leftProfits = new int[prices.length];
      int[] rightProfits = new int[prices.length+1];

      int maxProfit = 0;
      int profit = prices[0];
      for(int i=1;i<prices.length;i++){
          leftProfits[i] = Math.max(leftProfits[i-1],prices[i]-profit);
          profit = Math.min(profit,prices[i]);
      }

      profit = prices[prices.length-1];
      for(int i=prices.length-1;i>=0;i--){
            rightProfits[i] = Math.max(rightProfits[i+1],profit-prices[i]);
            profit = Math.max(profit,prices[i]);
      }
      for(int i=0;i<prices.length;i++){
          maxProfit = Math.max(maxProfit,leftProfits[i]+rightProfits[i+1]);
      }
      return maxProfit;
    }
}
