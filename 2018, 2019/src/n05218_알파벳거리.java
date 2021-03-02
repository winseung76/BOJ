import java.util.Scanner;

public class n05218_¾ËÆÄºª°Å¸® {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String s1 = sc.next();
			String s2 = sc.next();

			System.out.print("Distances: ");
			for (int j = 0; j < s1.length(); j++) {
				char c1 = s1.charAt(j);
				char c2 = s2.charAt(j);
				if (c1 <= c2)
					System.out.print(c2 - c1 + " ");
				else {
					System.out.print((c2 + 26 - c1) + " ");
				}
			}
			System.out.println();
		}

	}
}
