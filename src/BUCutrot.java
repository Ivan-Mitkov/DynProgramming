import java.util.Scanner;

public class BUCutrot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] b = sc.nextLine().split(" ");
		int[]prices= new int[b.length];
		for(int j = 0; j<b.length; j++){
			prices[j]=Integer.parseInt(b[j]);
		}
		int n = Integer.parseInt(sc.nextLine());
		int[][] res = BUpCutRot(prices,n);
		
		System.out.println(res[0][n]);
		PrintCutRotSol(res, n);
	}
	

	private static void PrintCutRotSol(int[][] res,int n) {
		while(n>0){
			System.out.print(res[1][n]+" ");
			n=n-res[1][n];
		}
		
	}


	private static int[][] BUpCutRot(int[] prices, int meter) {
		int [][] r= new int[2][prices.length];
		
		r[0][0]=0;
		int q=0;
		for(int first =1; first<=meter; first++){
			q=-1;
			for(int second=1; second<=first; second++){
				if(q<Math.max(q,prices[second]+r[0][first-second])){
					q= Math.max(q,prices[second]+r[0][first-second]);
					r[1][first]=second;
				}
				
			}
			r[0][first]=q;
			
		}
		return r;
	}

}
