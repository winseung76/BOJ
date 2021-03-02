import java.util.Scanner;

public class n01932_Á¤¼ö»ï°¢Çü {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] tri = new int[n][];
		for (int i = 0; i < n; i++) {
			tri[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				tri[i][j] = Math.max(tri[i + 1][j], tri[i + 1][j + 1]) + tri[i][j];
			}
		}
		System.out.println(tri[0][0]);

	}
}
