import java.util.Scanner;

public class n10569_�ٸ�ü {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			System.out.println(E - V + 2);
		}
	}
}
