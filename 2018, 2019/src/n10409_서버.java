import java.util.Scanner;

public class n10409_¼­¹ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int T = sc.nextInt();
		int sum = 0;
		int i;
		for (i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (sum + x > T)
				break;
			sum += x;
		}
		System.out.println(i);

	}
}
