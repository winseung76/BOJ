import java.util.Arrays;
import java.util.Scanner;

public class n01049_±‚≈∏¡Ÿ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int price = 0;
		int[] pack = new int[M];
		int[] piece = new int[M];

		for (int i = 0; i < M; i++) {
			pack[i] = sc.nextInt();
			piece[i] = sc.nextInt();
		}
		Arrays.sort(pack);
		Arrays.sort(piece);
		price = Math.min(pack[0], piece[0] * 6) * (N / 6) + Math.min(pack[0], piece[0] * (N % 6));
		System.out.println(price);

	}
}
