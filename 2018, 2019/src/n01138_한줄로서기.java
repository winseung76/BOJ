import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class n01138_한줄로서기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		LinkedList result = new LinkedList();

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = n - 1; i >= 0; i--) {
			int leftTall = arr[i];
			result.add(leftTall, i + 1);
		}
		Iterator it = result.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}
