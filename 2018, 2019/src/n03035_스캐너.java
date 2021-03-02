import java.util.Scanner;

public class n03035_½ºÄ³³Ê {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		int ZR = sc.nextInt();
		int ZC = sc.nextInt();
		char[][] org = new char[R][C];

		for (int i = 0; i < R; i++) {
			String s = sc.next();
			for (int j = 0; j < C; j++) {
				org[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < R * ZR; i++) {
			for (int j = 0; j < C * ZC; j++) {
				System.out.print(org[i / ZR][j / ZC]);
			}
			System.out.println();
		}

	}
}
