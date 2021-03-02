import java.util.Scanner;

public class n10250_ACM_хёез {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int res;
			if (N % H == 0)
				res = H * 100 + (N / H);
			else
				res = N % H * 100 + (N / H + 1);
			System.out.println(res);
		}

	}
}
