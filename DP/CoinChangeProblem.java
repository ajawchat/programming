// A recursive approach to the coin change problem

package DP;

public class CoinChangeProblem {

	
	
	public int getMinCoins(int n, int[] arr){
		int min = 1000;
		
		for(int i = 0; i< arr.length; i++){
			if(n == arr[i])
				min = 1;
			else if (n > arr[i])
				min = 1 + getMinCoins(n-arr[i], arr);
		}
		
		return min;
	}
	
	public static void main(String[] args) {
		CoinChangeProblem coinChange = new CoinChangeProblem();
		
		int[] arr = {1,2,3};
		
		int no = coinChange.getMinCoins(17, arr);
		System.out.println(no);

	}

}
