import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		int capacity = Integer.parseInt(c);
		//System.out.println(capacity);
		ArrayList<Item> items = new ArrayList<>(0);

		while (true) {

			String input = sc.nextLine();
			if (input .equals("end"))
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
	
		int sum = knapSack(capacity, items, n);
		System.out.println(sum);
	}

	private static int knapSack(int capacity, ArrayList<Item> items,int n) {
		if(capacity==0||n==0)return 0;
		if(items.get(n-1).GetMass()>capacity){
			return knapSack(capacity, items,n-1);
		}
		else{
			return Math.max(items.get(n-1).GetValue()
					+knapSack(capacity-items.get(n-1).GetMass(),items,n-1),
					knapSack(capacity,items,n-1));
		}
		
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
		public String toString(){
			return this.name;
		}
	}

}
