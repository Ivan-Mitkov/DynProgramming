import java.util.Scanner;

public class BinomialCoefficients {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		long[][] memo = new long[n + 1][m + 1];
		long res = BinomDP(n, m, memo);
		System.out.println(res);
	}

	private static long BinomDP(int n, int k, long[][] memo) {
		if (memo[n][k] != 0)
			return memo[n][k];

		if (k > n) {

			return 0;
		}
		if (k == 0) {

			return 1;
		}
		if (k == n) {
			return 1;
		}
		memo[n][k] = BinomDP(n - 1, k - 1, memo) + BinomDP(n - 1, k, memo);

		return memo[n][k];

	}

}
