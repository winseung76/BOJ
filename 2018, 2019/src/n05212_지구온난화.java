import java.util.Scanner;

public class n05212_지구온난화 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] x = { -1, 0, 1, 0 };
		int[] y = { 0, 1, 0, -1 };
		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] arr = new char[R + 2][C + 2];
		String str = "";

		for (int i = 0; i < R + 2; i++) {
			if (0 < i && i < R + 1)
				str = sc.next();
			for (int j = 0; j < C + 2; j++) {
				if (i == 0 || i == R + 1 || j == 0 || j == C + 1)
					arr[i][j] = '.';
				else
					arr[i][j] = str.charAt(j - 1);
			}
		}
		char[][] org = new char[R + 2][C + 2];
		for (int i = 0; i < R + 2; i++)
			System.arraycopy(arr[i], 0, org[i], 0, arr[i].length);

		int land_count = 0;
		for (int i = 0; i < R + 2; i++) {
			for (int j = 0; j < C + 2; j++) {
				if (arr[i][j] == 'X')
					land_count++;
			}
		}
		if (land_count > 1) {
			for (int i = 1; i < R + 1; i++) {
				for (int j = 1; j < C + 1; j++) {
					int count = 0;
					if (org[i][j] == 'X') {

						for (int k = 0; k < 4; k++) {
							int r = i + y[k];
							int c = j + x[k];
							if (org[r][c] == '.')
								count++;
						}

					}
					if (count >= 3)
						arr[i][j] = '.';
				}
			}
		}

		int up_r = R + 3, down_r = -1, left_c = C + 3, right_c = -1;
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {

				if (arr[i][j] == 'X') {
					if (left_c > j)
						left_c = j;
					if (right_c < j)
						right_c = j;

					if (up_r > i)
						up_r = i;
					if (down_r < i)
						down_r = i;
				}
			}
		}

		for (int i = up_r; i <= down_r; i++) {
			for (int j = left_c; j <= right_c; j++)
				System.out.print(arr[i][j]);
			System.out.println();
		}

	}
}
