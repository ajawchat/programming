package DP;

public class LISTest {
	
	int[] dp = {0,0,0,0,0,0,0,0,0,0};

	// This is the solution using Dynamic Programming. We cache the results in the array dp
	public int getLISDP(int n, int[] arr){
		int LIS=1;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j]){
					LIS = 1 + dp[j];
				}
			}
			dp[i] = LIS;
		}
		return LIS;
	}
	
	
	
	
	
	// This is the recursive solution
	public int getLIS(int n, int[] arr){
		int LIS=1;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j]){
					LIS = 1 + getLIS(j+1,arr);
				}
			}
		}
		
		return LIS;
	}
	
	
	public static void main(String[] args) {
		LISTest lis = new LISTest();
		
		int[] arr = {10,22,9,33,21,50,41,60,80};
		
		int longest = lis.getLIS(arr.length, arr);
		System.out.println(longest);
		
		
		longest = lis.getLISDP(arr.length, arr);
		System.out.println(longest);
		
	}

}
