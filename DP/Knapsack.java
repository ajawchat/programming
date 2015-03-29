package DP;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	
	public void KN(int[] weight, int[] b, int W){
		int[][] arr = new int[weight.length+1][W+1];
		
		List<Integer> solution = new ArrayList<Integer>();
		
		
		for(int i=0; i<=weight.length; i++){
			arr[i][0] = 0;
		}
		
		for(int i=0; i<=W; i++){
			arr[0][i] = 0;
		}
		
		for(int i=1; i<= weight.length; i++){
			for(int j = 1; j <= W; j++){
				if(weight[i-1] <= j && j-weight[i-1] >= 0){
					arr[i][j] = Math.max(arr[i-1][j] , b[i-1]+arr[i-1][j-weight[i-1]]);
					System.out.println(arr[i][j]);
				}
				else
					arr[i][j] = arr[i-1][j];
			
			}
		}
		
		System.out.println("total benefit = "+arr[weight.length][W]);
		
		
	}
	
	
	//-----------------------------------------------------------------
	
	public void deleteSolutionElem(List<Integer> solution){
		for(int i = 0; i < solution.size(); i++){
			solution.remove(i);
		}
	}
	
	
	public void Knapsack(int[] weight, int[] benefit, int W){
		int maxBenefit = 0;
		List<Integer> solution = new ArrayList<Integer>();
		
		for(int l=1; l <weight.length-1; l++){
			for(int i=0; i < weight.length-l+1; i++){
				System.out.println("i="+i);
				int j = i + l-1;
				System.out.println("j="+j);
				//System.out.println("Max = "+maxBenefit);
				int currWeight = 0;
				int currBenefit = 0;
				for(int k = i; k <= j; k++){
					//System.out.println("k="+k);
					currWeight += weight[k];
					if(currWeight <= W)
						currBenefit += benefit[k];
					System.out.println(currBenefit);
				}
				
				if(currBenefit > maxBenefit){
					maxBenefit = currBenefit;
					System.out.println("Now max="+currBenefit);
					
					deleteSolutionElem(solution);
					
					for(int k = i; k <= j; k++)
						solution.add(weight[k]);
				}
				
			}
		}
		
		// display the solution
		System.out.println("Max benefit = "+maxBenefit);
		for(int i = 0; i<solution.size(); i++)
			System.out.print(solution.get(i)+", ");
		
		
	}
	
	public static void main(String[] args) {
		int[] w = {2,3,4,5,1};
		int[] b = {3,4,5,6,8};
		
		Knapsack knap = new Knapsack();
		//knap.Knapsack(w, b, 5);
		knap.KN(w, b, 5);

	}

}
