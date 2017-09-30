import java.util.Scanner;

public class Fibo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long memo[]=new long[n+2];
		long fib = Fibo(n,memo);
		
		System.out.println(fib);

	}

	private static long Fibo(int n,long[] memo) {
		
		
		if(memo[n]!=0){
			return memo[n];
		}
		
		if(n<=2){
			memo[n]=1;
			return memo[n];
		}
		else{
			
			memo[n]=Fibo(n-1,memo)+Fibo(n-2,memo);
			return memo[n];
		}
		
	}

}

