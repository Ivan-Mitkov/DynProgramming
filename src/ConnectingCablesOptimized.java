import java.util.Scanner;

public class ConnectingCablesOptimized {

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
		
		int[][] maxConnect=new int[seq.length+1][seq.length+1];
		for(int i =0; i<maxConnect.length; i++){
			for (int j = 0; j < maxConnect.length; j++) {
				maxConnect[i][j]=-1;
			}
			
		}
		int maxConnected=GetMaxConnected(inOrder.length-1,seq.length-1,inOrder,seq,maxConnect);
		System.out.println("Maximum pairs connected: "+maxConnected);
	}

	private static int GetMaxConnected(int x, int y,int[]inOrder,int[]seq,int[][]maxConnect) {
		if(x<0||y<0){
			return 0;
		}
		if(maxConnect[x][y]!=-1){
			return maxConnect[x][y];
		}
		
		if(inOrder[x]==seq[y]){
			maxConnect[x][y] =GetMaxConnected(x-1,y-1,inOrder,seq,maxConnect)+1;
		}
		else{
			int reduceInOrder=GetMaxConnected(x-1,y,inOrder,seq,maxConnect);
			int reduceSeq=GetMaxConnected(x,y-1,inOrder,seq,maxConnect);
			maxConnect[x][y]= Math.max(reduceInOrder, reduceSeq);
		}
		return maxConnect[x][y];
	}
	

}
