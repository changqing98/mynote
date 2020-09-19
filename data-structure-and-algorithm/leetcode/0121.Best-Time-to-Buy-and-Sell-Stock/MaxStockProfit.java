import java.lang.Math;

public class MaxStockProfit {
	/**
	 * maxProfit = max(maxProfit, array[i] - minPrice)
	 */
    public int maxProfit(int[] prices) {
		if(prices.length == 0){
			return 0;
		}
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
    }

	public static void main(String[] args) {
		MaxStockProfit test = new MaxStockProfit();
		int[] array = new int[]{7,1,5,3,6,4};
		int result = test.maxProfit(array);
		System.out.println(result);
	}
}
