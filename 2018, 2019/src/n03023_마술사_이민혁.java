import java.util.Scanner;

public class n03023_¸¶¼ú»ç_ÀÌ¹ÎÇõ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int er, ec;
		char[][] arr = new char[2 * R][2 * C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		er = sc.nextInt();
		ec = sc.nextInt();

		for (int i = 0; i < R; i++) {
			for (int j = C; j < 2 * C; j++) {
				arr[i][j] = arr[i][2 * C - 1 - j];
			}
		}
		for (int i = R; i < 2 * R; i++) {
			for (int j = 0; j < 2 * C; j++) {
				arr[i][j] = arr[2 * R - 1 - i][j];
			}
		}
		char c = arr[er - 1][ec - 1];
		if (c == '.')
			arr[er - 1][ec - 1] = '#';
		else
			arr[er - 1][ec - 1] = '.';

		for (int i = 0; i < 2 * R; i++) {
			for (int j = 0; j < 2 * C; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}
	}
}
