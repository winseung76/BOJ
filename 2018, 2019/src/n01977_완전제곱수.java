import java.util.Scanner;

public class n01977_¿ÏÀüÁ¦°ö¼ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min;
		int n = 0;
		while (M > n * n)
			n++;
		min = n * n;
		while (n * n <= N) {
			sum += n * n;
			n++;
		}
		if (sum == 0)
			System.out.println(-1);
		else
			System.out.println(sum + "\n" + min);
	}
}
