import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class n03052_³ª¸ÓÁö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList arr = new ArrayList();
		for (int i = 0; i < 10; i++) {
			int n = sc.nextInt();

			arr.add(n % 42);
		}

		HashSet set = new HashSet(arr);

		System.out.println(set.size());

	}
}
