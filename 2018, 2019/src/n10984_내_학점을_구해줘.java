import java.util.Scanner;

public class n10984_내_학점을_구해줘 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int a = 0;
			double sum = 0;
			for (int j = 0; j < N; j++) {
				int g = sc.nextInt();
				double s = sc.nextDouble();
				a += g;
				sum += g * s;
			}
			System.out.println(a + " " + String.format("%.1f", sum / a));
		}
	}
}
