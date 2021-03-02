import java.util.Scanner;

public class n12790_Mini_Fantasy_War {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int result = 0;
		int[] capacity;
		for (int i = 0; i < T; i++) {
			result = 0;
			capacity = new int[4];
			for (int j = 0; j < 8; j++) {
				capacity[j % 4] += sc.nextInt();
			}
			if (capacity[0] < 1)
				capacity[0] = 1;
			result += capacity[0];
			if (capacity[1] < 1)
				capacity[1] = 1;
			result += 5 * capacity[1];
			if (capacity[2] < 0)
				capacity[2] = 0;
			result += 2 * capacity[2];
			result += 2 * capacity[3];

			System.out.println(result);

		}
	}
}
