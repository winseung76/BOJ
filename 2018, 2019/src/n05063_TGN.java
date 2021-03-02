import java.util.Scanner;

public class n05063_TGN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int r = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();

			if (e - c > r)
				System.out.println("advertise");
			else if (e - c == r)
				System.out.println("does not matter");
			else
				System.out.println("do not advertise");
		}

	}
}
