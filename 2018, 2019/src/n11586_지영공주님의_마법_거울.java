import java.util.Scanner;

public class n11586_지영공주님의_마법_거울 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		char[][] mirror = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				mirror[i][j] = str.charAt(j);
			}
		}
		int K = sc.nextInt();
		char[][] res = new char[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char ch = ' ';
				switch (K) {
				case 1:
					ch = mirror[i][j];
					break;
				case 2:
					ch = mirror[i][N - 1 - j];
					break;
				case 3:
					ch = mirror[N - 1 - i][j];
					break;
				}
				System.out.print(ch);
			}
			System.out.println();
		}

	}
}
