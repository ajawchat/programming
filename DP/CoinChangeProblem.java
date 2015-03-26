// A recursive approach to the coin change problem

package DP;

public class CoinChangeProblem {
	
	// Caching the results for future use
	int[] minCoins = new int[100];
	
	// Function to initialize the caching array
	public void initialize(){
		for(int i = 0; i < minCoins.length; i++){
			minCoins[i] = 0;
		}
	}
	
	// Function to get the min no of coins using DP approach
	public int getMinCoins(int n, int[] arr){
		int min = 1000;
		
		if(minCoins[n] > 0){
			System.out.println("accessing table");
			return minCoins[n];
		}
		
		for(int i = 0; i< arr.length; i++){
			if(n == arr[i])
				min = 1;
			else if (n > arr[i])
				if(minCoins[n-arr[i]] > 0){
					min = 1 + minCoins[n-arr[i]];
					System.out.println("accessing table for "+(n-arr[i]));
				}
				else
					min = 1 + getMinCoins(n-arr[i], arr);
		}
		
		minCoins[n] = min;
		return min;
	}
	
	public static void main(String[] args) {
		CoinChangeProblem coinChange = new CoinChangeProblem();
		
		int[] arr = {1,2,3};
		
		coinChange.initialize();
		
		int no = coinChange.getMinCoins(17, arr);
		System.out.println(no);

	}

}
