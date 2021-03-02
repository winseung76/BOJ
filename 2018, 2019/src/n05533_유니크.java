import java.util.Scanner;

public class n05533_¿Ø¥œ≈© {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] arr = new int[3][N];

		for (int i = 0; i < N; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
			arr[2][i] = sc.nextInt();
		}
		int sum = 0, count;

		sum = 0;
		for (int i = 0; i < N; i++) {
			sum = 0;
			for (int j = 0; j < 3; j++) {
				int n = arr[j][i];
				count = 0;
				for (int k = 0; k < N; k++) {
					if (i != k && arr[j][k] == n)
						count++;
				}
				if (count == 0)
					sum += n;
			}
			System.out.println(sum);
		}

	}
}
