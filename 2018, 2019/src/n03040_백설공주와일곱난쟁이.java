import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class n03040_归汲傍林客老蚌抄里捞 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		LinkedHashSet<Integer> sets = new LinkedHashSet<>();

		int[] arr = new int[9];
		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();
			sets.add(n);
			sum += n;
		}
		int chg = sum - 100;
		Iterator it = sets.iterator();
		while (it.hasNext()) {
			int x = (int) it.next();
			if (x >= chg || !sets.contains(chg - x) || x == chg - x) {
				System.out.println(x);
			}
		}

	}
}
