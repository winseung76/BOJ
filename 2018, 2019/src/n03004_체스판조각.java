import java.util.Scanner;

public class n03004_체스판조각 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N % 2 == 0)
			System.out.println((int) Math.pow(N / 2 + 1, 2));
		else if (N % 2 == 1)
			System.out.println((N / 2 + 1) * (N / 2 + 2));

	}
}
