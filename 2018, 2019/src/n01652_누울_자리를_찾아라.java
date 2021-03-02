import java.util.Scanner;

public class n01652_누울_자리를_찾아라 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row_size = 0, row = 0, col = 0;

		int N = sc.nextInt();
		char[][] room = new char[N][N];
		int[] col_size = new int[N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			row_size = 0;
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				room[i][j] = c;

				if (c == 'X') {
					if (row_size >= 2)
						row++;
					row_size = 0;

					if (col_size[j] >= 2)
						col++;
					col_size[j] = 0;
				} else if (c == '.') {
					row_size++;
					col_size[j]++;
				}
			}
			if (row_size >= 2)
				row++;
		}
		for (int i = 0; i < N; i++) {
			if (col_size[i] >= 2)
				col++;
		}
		System.out.println(row + " " + col);
	}
}
