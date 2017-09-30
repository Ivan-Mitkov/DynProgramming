import java.util.Scanner;

public class Lis {

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		 String [] numb = input.split(" ");
		int[] numbers = new int[numb.length];
		
		for(int i = 0; i<numb.length; i++){
			numbers[i]= Integer.parseInt(numb[i]);
		}
		int[] memo=new int[numbers.length];
		int[] prev= new int[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			 Liss(i, memo, numbers, prev);
		}
		int max = findMax(memo);
		PrintMax(numbers, prev, max);
		
	}

	private static void PrintMax(int[] numbers, int[] prev, int max) {
		System.out.print(+numbers[max]);
		if(prev[max]!=-1){
			int cur= prev[max];
			while(prev[cur]!=-1){
				System.out.print(" "+numbers[cur]);
				cur=prev[cur];
			}
			System.out.print(" "+numbers[cur]);
		}
		
	}

	private static int findMax(int[] memo) {
		int max=memo[0];
		int index=0;
		for(int i = 0; i<memo.length; i++){
			if(memo[i]>max){
				max=memo[i];
				index=i;
			}
		}
		return index;
	}

	private static int Liss(int index, int[] memo, int[] numbers, int[] prev) {
		
		if(memo[index]!=0){
			return memo[index];
		}
		int maxlen=1;
		prev[index]= -1;
		for (int i = index+1; i < numbers.length; i++) {
			if(numbers[index]<numbers[i]){
				int lenght = Liss(i, memo, numbers, prev);
				if(lenght>=maxlen){
					maxlen=lenght+1;
					prev[index]=i;
				}
				
			}
			if(memo[i]>maxlen){
				maxlen=memo[i];
				
			}
		}
		memo[index]=maxlen;
		return maxlen;
		
	}

}
