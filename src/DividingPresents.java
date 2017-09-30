import java.util.Scanner;

public class DividingPresents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] b = sc.nextLine().split(" ");
		int[] values = new int[b.length];
		for (int j = 0; j < b.length; j++) {
			values[j] = Integer.parseInt(b[j]);
		}
		int totalSum = FindTotalSum(values);
		// System.out.println(totalSum);
		int[] isThereASum = new int[totalSum + 1];
		for (int k = 0; k < isThereASum.length; k++) {
			isThereASum[k] = -1;
		}
		FillPossbleSums(isThereASum, values);
//		for (int k = 0; k < isThereASum.length; k++) {
//			System.out.println("K: " + k + " isThereASum[k]: " + isThereASum[k] + "values:"+ values[isThereASum[k]]+"|");
//		}
//		System.out.println();

		int half = totalSum / 2;
		for (int k = half; k >= 0; k--) {

			if (isThereASum[k] > 0) {

				System.out.println("Difference: " + (totalSum - k - k));
				System.out.println("Alan:" + k + " Bob:" + (totalSum - k));
				System.out.println("Alan takes: " + GetAlanPresents(k,isThereASum,values));
				break;
			}

		}
		
		System.out.println("Bob takes the rest.");
	}

	private static String GetAlanPresents(int k,int[] isThereASum, int[] values) {
		String result="";
		while(k!=0){
			result+=values[isThereASum[k]]+" ";
			k=k-values[isThereASum[k]];
		}
		
		return result;
	}

	private static void FillPossbleSums(int[] isThereASum, int[] values) {
		isThereASum[0] = 0;

		for (int i = 0; i < values.length; i++) {

			for (int j = isThereASum.length - 1; j >= 0; j--) {

				if (isThereASum[j] != -1 && isThereASum[j + values[i]] == -1) {
					isThereASum[j + values[i]] = i;
				}
			}
		}

	}

	private static int FindTotalSum(int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

}
