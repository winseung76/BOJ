import java.util.Scanner;

public class n03985_롤케이크 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int[] cake = new int[L];
		int N = sc.nextInt();
		int[] cnt = new int[N];

		int res1 = 0, res2 = 0;
		int max1 = 0, max2 = 0;

		for (int i = 0; i < N; i++) {
			int p = sc.nextInt();
			int k = sc.nextInt();
			if (max1 < k - p) {
				res1 = i + 1;
				max1 = k - p;
			}

			for (int j = p; j <= k; j++) {
				if (cake[j - 1] == 0) {
					cake[j - 1] = i + 1;
					cnt[i]++;
				}
			}
			if (max2 < cnt[i]) {
				res2 = i + 1;
				max2 = cnt[i];
			}
		}

		System.out.println(res1);
		System.out.println(res2);

	}
}
