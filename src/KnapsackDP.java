import java.util.ArrayList;
import java.util.Scanner;

public class KnapsackDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		int capacity = Integer.parseInt(c);
		// System.out.println(capacity);
		ArrayList<Item> items = new ArrayList<>(0);

		while (true) {

			String input = sc.nextLine();
			if (input.equals("end"))
				break;
			else {
				String[] b = input.split(" ");
				Item next = new Item();
				next.SetName(b[0]);
				next.SetValue(Integer.parseInt(b[2]));
				next.SetMass(Integer.parseInt(b[1]));
				items.add(next);
			}

		}
		int n = items.size();
		int K[][] = new int[n + 1][capacity + 1];
		boolean[][] IsItTaken = new boolean[n + 1][capacity + 1];
		
		int sum = knapSack(capacity, items, n, K, IsItTaken);
//		for(int row=0; row<n + 1; row++){
//			for(int col=0; col<capacity + 1; col++){
//			
//				System.out.print(IsItTaken[row][col]+" ");
//			}
//			System.out.println();
//		}
		
		PrintTakenItems(IsItTaken,items);
	}

	private static void PrintTakenItems(boolean[][] isItTaken, ArrayList<Item> items) {
		ArrayList<Item>TakenItems=new  ArrayList<Item>();
		int startRow=isItTaken.length-1;
		int startCol=isItTaken[0].length-1;
		
		while(startCol>0&&startRow>0){
			Item current = items.get(startRow-1);
			
			if(isItTaken[startRow][startCol]==true&&(startRow>0&&startCol>0)){
				TakenItems.add(current);
				startCol=startCol-current.GetMass();
				startRow--;
				
			}
			else{
				while(isItTaken[startRow][startCol]!=true&&startRow>0){
					startRow--;
				}
			}
		}
		int totalWeight=0;
		for(int i=TakenItems.size()-1;i>=0; i--){
			totalWeight+=TakenItems.get(i).GetMass();
		}
		System.out.println("Total Weight: "+totalWeight);
		int totalValue=0;
		for(int i=TakenItems.size()-1;i>=0; i--){
			totalValue+=TakenItems.get(i).GetValue();
		}
		System.out.println("Total Value: "+totalValue);
		for(int i=TakenItems.size()-1;i>=0; i--){
			System.out.println(TakenItems.get(i));
		}
		
		
	}

	private static int knapSack(int capacity, ArrayList<Item> items, int n, int K[][],boolean[][] IsItTaken) {
		
		for (int i = 0; i <= n; i++) {
			for (int curCap = 0; curCap <= capacity; curCap++) {
				
				if (i == 0 || curCap == 0){
					K[i][curCap] = 0;
					IsItTaken[i][curCap]=false;
				}
					
				
				else if (items.get(i - 1).GetMass() <= curCap) {
					Item current = items.get(i-1);
					int currentValue= current.GetValue();
					int currentMass=current.GetMass();
					
					K[i][curCap] = Math.max(currentValue
							+ K[i - 1][curCap - currentMass],
							K[i - 1][curCap]);
					if(currentValue + K[i - 1][curCap - currentMass]>K[i - 1][curCap]){
						IsItTaken[i][curCap]=true;
					}
					
					
				} else {
					K[i][curCap] = K[i - 1][curCap];
				}
			}
		}

		return K[n][capacity];

	}

	public static class Item {
		String name;
		int mass;
		int value;

		public Item() {
			this.name = "";
			this.mass = 0;
			this.value = 0;
		};

		public Item(String name, int mass, int value) {
			this.name = name;
			this.mass = mass;
			this.value = value;
		}

		public void SetName(String name) {
			this.name = name;
		}

		public String GetName() {
			return this.name;
		}

		public void SetMass(int mass) {
			this.mass = mass;
		}

		public int GetMass() {
			return this.mass;
		}

		public void SetValue(int value) {
			this.value = value;
		}

		public int GetValue() {
			return this.value;
		}

		public String toString() {
			return this.name;
		}
	}

}
