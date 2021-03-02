import java.util.Scanner;

public class n01978_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int result = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int count = 0;
			for (int j = 2; j < x; j++) {
				if (x % j == 0)
					count++;
			}
			if (x > 1 && count == 0)
				result++;
		}
		System.out.println(result);

	}
}
