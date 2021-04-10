package com.chintan.ds;

public class StockProfit {

    private static void findMaxProfit(int[] arr) {
        int buyDay = 0;
        int sellDay = 0;
        int buyPointer = 0;
        int sellPointer = 1;
        int profit = 0;

        while (buyPointer < arr.length && sellPointer < arr.length) {
            while (arr[buyPointer] > arr[sellPointer]) {
                buyPointer++;
            }
            int currentProfit = arr[sellPointer] - arr[buyPointer];
            if (currentProfit > profit) {
                buyDay = buyPointer;
                sellDay = sellPointer;
                profit = currentProfit;
            }
            sellPointer++;
        }

        System.out.println("Buy Day: " + (buyDay + 1));
        System.out.println("Sell Day: " + (sellDay + 1));
        System.out.println("Profit: " + profit);
    }

    public static void main(String[] args) {
        int[] profitArray = {14, 12, 70, 15, 99, 1, 21, 90};
        findMaxProfit(profitArray);
    }
}
