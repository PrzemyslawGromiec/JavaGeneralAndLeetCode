package org.example.Arrays.best_time_stock_121;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 4, 4, 3, 6, 8};
        System.out.println(maxProfit(prices));
        System.out.println(Arrays.toString(maxProfitWithDays(prices)));
        System.out.println(Arrays.toString(maxProfitWithWeekDays(prices)));
    }

    /*
    * prices - array where prices[i] is the price of a given stock on the i day
    * maximize profit by choosing single day to buy one stock
    * choose a different day in the future to sell that stock
    * return max profit
    * if no profit, return 0*/

    public static int maxProfit(int[] prices) {
        //dostaje tablice wartosci
        //wybieram najmniejsza wartosc
        //sprawdzam czy po niej jest wartosc wieksza
//        prices = [7,1,5,3,6,4]
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        System.out.println("Iteration | Current Price | Lowest Price So Far | Profit | Max Profit");
        System.out.println("---------------------------------------------------------------");

        for (int price : prices) {
            if (price < lowestPrice) {
                lowestPrice = price;
            } else {
                int profit = price - lowestPrice;
                maxProfit = Math.max(maxProfit,profit);
            }
            int profit = Math.max(0, price - lowestPrice); // Oblicz profit dla aktualnego price
            System.out.printf("%9d | %13d | %17d | %6d | %10d%n",
                    price, price, lowestPrice, profit, maxProfit);
        }
        return maxProfit;
    }

    public static int[] maxProfitWithDays(int[] prices) {
        if (prices == null || prices.length < 2) {
            return new int[]{-1,-1};
        }

        int lowestPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int buyDay = -1;
        int sellDay = -1;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
                buyDay = i;
            } else {
                int profit = prices[i] - lowestPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    sellDay = i;
                }
            }
        }
        return new int[]{buyDay,sellDay};
    }

    public static String[] maxProfitWithWeekDays(int[] prices) {
        if (prices == null || prices.length < 2) return new String[]{"N/A", "N/A"}; // Brak wyniku

        int lowestPrice = Integer.MAX_VALUE; // Najniższa cena
        int maxProfit = 0; // Maksymalny zysk
        int buyDay = -1; // Dzień kupna
        int sellDay = -1; // Dzień sprzedaży

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                // Aktualizacja najniższej ceny i dnia kupna
                lowestPrice = prices[i];
                buyDay = i;
            } else {
                int profit = prices[i] - lowestPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                    sellDay = i;
                }
            }
        }

        return new String[]{weekDays[buyDay % 7], weekDays[sellDay % 7]};
    }

}
