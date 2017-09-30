import java.util.Scanner;

public class MemoizedCurRot {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] b = sc.nextLine().split(" ");
		int[]prices= new int[b.length];
		for(int j = 0; j<b.length; j++){
			prices[j]=Integer.parseInt(b[j]);
		}
		int n = Integer.parseInt(sc.nextLine());
		int res = MemoizedCutRod(prices,n);
		
		System.out.println(res);
		
	}
	

	private static int MemoizedCutRod(int[] prices, int n) {
		int[] r = new int[prices.length];
		for(int i=0; i<prices.length; i++){
			r[i]=-1;
		}
		return CutRod(prices, n, r);
		
	}


	private static int  CutRod(int[] prices, int meter,int[]r) {
		int q=0;
		if(r[meter]>=0)return r[meter];
		if(meter==0){
			q=0;
		}
		else{
			q=0;
			for(int i =1; i<=meter; i++){
				q=Math.max(q, prices[i]+CutRod(prices, meter-i,r));
			}
		}
		r[meter]=q;
		return q;
		
	}

}
