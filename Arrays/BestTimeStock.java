public class BestTimeStock {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
        
    }

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - min);

        }
        return maxprofit;
    }
}
