import java.util.Scanner;

public class n01100_го╬А_д╜ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[8][8];
		int count = 0;

		for (int i = 0; i < 8; i++) {
			String str = sc.nextLine();

			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == 'F') {
					if (i % 2 == 0 && j % 2 == 0)
						count++;
					else if (i % 2 == 1 && j % 2 == 1)
						count++;
				}
			}
		}
		System.out.println(count);

	}
}
