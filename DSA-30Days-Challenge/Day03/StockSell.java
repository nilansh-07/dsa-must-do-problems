public class StockSell {
    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Buy here
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Sell here
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println("The maximum profit is: " + maxProfit(prices));
    }
}
