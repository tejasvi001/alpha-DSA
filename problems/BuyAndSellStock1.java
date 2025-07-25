package problems;

public class BuyAndSellStock1 {
	public static int maxProfit(int arr[]) {
		int buyPrice=Integer.MAX_VALUE;
		int maxProfit=0;
		for(int i=0;i<arr.length;i++) {
			if(buyPrice>arr[i]) {
				buyPrice=arr[i];
			}else {
				maxProfit=Math.max(maxProfit, arr[i]-buyPrice);
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[]= {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

}
