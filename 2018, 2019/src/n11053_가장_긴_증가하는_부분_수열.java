import java.util.Scanner;

public class n11053_����_��_�����ϴ�_�κ�_���� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N];
		int[] arr = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if (i == 0)
				dp[i] = 1;
			else {
				int max = 0;
				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i]) {
						max = Math.max(dp[j], max);
					}
				}
				dp[i] = max + 1;
			}
			result = Math.max(dp[i], result);
		}
		System.out.println(result);
	}
}
