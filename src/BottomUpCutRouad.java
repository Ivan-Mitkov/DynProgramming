import java.util.Scanner;

public class BottomUpCutRouad {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] b = sc.nextLine().split(" ");
		int[]prices= new int[b.length];
		for(int j = 0; j<b.length; j++){
			prices[j]=Integer.parseInt(b[j]);
		}
		int n = Integer.parseInt(sc.nextLine());
		int res = CutRod(prices,n);
		
		System.out.println(res);
		
	}

	private static int  CutRod(int[] prices, int meter) {
		int n = prices.length;
		if(meter==0)return 0;
		int q=0;
		for(int i =1; i<=meter; i++){
			q=Math.max(q, prices[i]+CutRod(prices, meter-i));
		}
		return q;
		
	}
	
	

}
