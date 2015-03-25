// A DP approach to find the no of paths that can be traversed along a matrix

package DP;

public class RobotTraverse {

	public int getNoPaths(int n){
		
		int[][] arr = new int[n][n];

		for(int i = n-1; i >= 0; i--){
			for(int j = n-1; j >= 0; j--){
				if(i==n-1 || j==n-1)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i+1][j] + arr[i][j+1];
			}
		}

		return arr[0][0];

	}
	
	public static void main(String[] args) {
		RobotTraverse robotPath = new RobotTraverse();
		System.out.println(robotPath.getNoPaths(4));

	}

}
