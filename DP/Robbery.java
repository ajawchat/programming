package DP;

public class Robbery {

	int[] memoize = {0,0,0,0,0,0,0};
	
	public int rob(int[] num, int j) {
		System.out.println("j="+j);
        
		if(memoize[j] > 0){
			return memoize[j];
		}
			
		
		if(j == num.length || j == num.length-1){
            memoize[j] = num[j];
        	return num[j];
        }
        int val = 0;
        for(int k = j; k < num.length; k++){
            if(k+2 <= num.length-1){
            	if(memoize[k+2] > 0){
            		val = Math.max(val, memoize[k+2]+ num[k]);
            		System.out.println("got val for "+(k+2));
            	}
            	else
            		val = Math.max(val, rob(num,k+2)+ num[k]);
            }
                
                
        }
        
        memoize[j] = val;
        return val;
    }
	
	public static void main(String[] args) {
		Robbery robber = new Robbery();
		int[] num = {14,20,7,9,1,7,20};
		int val = robber.rob(num, 0);
		System.out.println(val);
		

	}

}
