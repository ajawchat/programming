package DP;

// Recursive program for rod cutting problem



public class RodTest {
	
	// Have a global array to store the most optimal values already computed, and using them for future look-ups
	int[] optimalValues = {0,0,0,0,0,0,0,0,0,0,0};
	
	public int getMax(int a, int b){
		if(a > b)
			return a;
		else
			return b;
	}
	
	
	public int cutRod(int[] p, int n){
		System.out.println("n="+n);
		int q = 0;
		if(n==0){
			return 0;
		}
		else{
			for(int i=1;i<=n;i++){
				if(optimalValues[n-i] > 0)
					q = getMax(q, p[i]+optimalValues[n-i]);
				else
					q = getMax(q, p[i]+cutRod(p,n-i));
			}
		}
		optimalValues[n] = q;
		System.out.println("Optimal value of "+n+" set to "+q);
		return q;
	}

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RodTest rod = new RodTest();
		
		int[] p = {0,1,5,8,9,10,17,17};
		
		
		
		System.out.println(rod.cutRod(p, 7));
		
		
	}

}
