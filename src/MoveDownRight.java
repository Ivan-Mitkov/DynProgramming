import java.util.ArrayList;
import java.util.Scanner;

public class MoveDownRight {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int m =Integer.parseInt(sc.nextLine());
		
		int matrix[][]=new int[n][m];
		for(int i = 0; i<n; i++){
			String[] b = sc.nextLine().split(" ");
			for(int j = 0; j<m; j++){
				matrix[i][j]=Integer.parseInt(b[j]);
			}
		}
		
		int rows= matrix.length;
		int cols= matrix[0].length;
		int memo[][]=new int[rows][cols];
		
		memo[0][0]=matrix[0][0];
		for (int row = 1; row < rows; row++) {
			
			memo[row][0]=memo[row-1][0]+ matrix[row][0];
			
		}
		for (int col = 1; col < cols; col++) {
			memo[0][col]=memo[0][col-1]+ matrix[0][col];
		}
		
		
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				memo[row][col]=Math.max(memo[row-1][col],memo[row][col-1])+matrix[row][col];
			}
		}
		ArrayList<String>path =AddPath(rows-1, cols-1, memo);
		for(int i = path.size()-1; i>0; i--){
			System.out.print(path.get(i)+" ");
		}
		System.out.print(path.get(0));
	}

	private static ArrayList<String> AddPath(int row, int col, int[][] memo) {
		ArrayList<String>path = new ArrayList<>();
		path.add("["+row+", "+col+"]");
		while(!(row==0&&col==0)){
			if(row==0){
				col--;
			}
			else if(col==0){
				row--;
			}
			else if(memo[row-1][col]>memo[row][col-1]){
				row--;
			}
			else{
				col--;
			}
			path.add("["+row+", "+col+"]");
		}
		return path;
	}

}
