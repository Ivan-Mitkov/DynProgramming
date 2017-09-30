import java.util.Scanner;

public class ConnectingCables {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] b = sc.nextLine().split(" ");
		int[] seq = new int[b.length];
		for (int j = 0; j < b.length; j++) {
			seq[j] = Integer.parseInt(b[j]);
		}
		int[]inOrder=new int[seq.length];
		for(int i =0; i<seq.length; i++){
			inOrder[i]=i+1;
		}
		int maxConnected=GetMaxConnected(inOrder.length-1,seq.length-1,inOrder,seq);
		System.out.println("Maximum pairs connected: "+maxConnected);
	}

	private static int GetMaxConnected(int x, int y,int[]inOrder,int[]seq) {
		if(x<0||y<0){
			return 0;
		}
		if(inOrder[x]==seq[y]){
			return GetMaxConnected(x-1,y-1,inOrder,seq)+1;
		}
		else{
			int reduceInOrder=GetMaxConnected(x-1,y,inOrder,seq);
			int reduceSeq=GetMaxConnected(x,y-1,inOrder,seq);
			return Math.max(reduceInOrder, reduceSeq);
		}
	}
	

}
