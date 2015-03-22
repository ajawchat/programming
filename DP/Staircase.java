package DP;

public class Staircase {

	public int countWays(int n){
		int ways = 0;
		System.out.println("n="+n);
		for(int i=1 ; i<=3 ; i++){
			if(n == i)
				ways += 1;
			else if(n > i){
				System.out.println("n-i="+(n-i));
				ways += countWays(n-i);
			}
		}
		System.out.println("For n="+n+", there are "+ways);
		return ways;
	}
	
	public static void main(String[] args) {
		Staircase stairs = new Staircase();
		System.out.println(stairs.countWays(2));
	}

}
