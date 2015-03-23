package DP;

public class Staircase {
	
	int[] counts;
	
	public int countWays(int n){
		int ways = 0;
		System.out.println("n="+n);
		
		if(n == 1){
			counts[1] = 1;
			return counts[1];
		}
		
		for(int i=1 ; i<=3 ; i++){
			if(n == i){
				ways += 1;
				System.out.println("Adding one more way");
			}
				
			else if(n > i){
				System.out.println("n-i="+(n-i));
				if(counts[n-i] > 0){
					System.out.println("already stored value received for "+(n-i));
					ways += counts[n-i];
				}
				else{
					System.out.println("recalculating it");
					counts[n-i] = countWays(n-i);
					ways += counts[n-i];
				}
			}
		}
		counts[n] = ways;
		System.out.println("For n="+n+", there are "+ways);
		return ways;
	}
	
	
	public void initializeArray(int n){
		counts = new int[n+1];
		for(int i = 0; i < n+1; i++)
			counts[i] = 0;
	}
	
	public void printArray(){
		for(int i = 0; i < counts.length; i++)
			System.out.print(counts[i]+"-");
	}
	
	
	
	public static void main(String[] args) {
		Staircase stairs = new Staircase();
		
		int n = 36;
		stairs.initializeArray(n);
		
		System.out.println(stairs.countWays(n));
		stairs.printArray();
	}

}
