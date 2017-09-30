import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String first = sc.nextLine();
		String second = sc.nextLine();
		char[] seq = new char[first.length()];
		for (int j = 0; j < first.length(); j++) {
			seq[j] = first.charAt(j);
		}
		char[]inOrder=new char[second.length()];
		for (int j = 0; j < second.length(); j++) {
			inOrder[j] = second.charAt(j);
		}
		int maxConnected=GetMaxConnected(inOrder.length-1,seq.length-1,inOrder,seq);
		System.out.println(maxConnected);
	}

	private static int GetMaxConnected(int x, int y,char[]inOrder,char[]seq) {
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
