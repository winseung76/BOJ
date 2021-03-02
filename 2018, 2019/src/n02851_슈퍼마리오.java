import java.util.Scanner;

public class n02851_½´ÆÛ¸¶¸®¿À {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int result = 0;
		int i;
		for (i = 0; i < 10; i++) {
			int n = sc.nextInt();
			sum += n;

			if (sum >= 100) {
				if (100 - (sum - n) >= sum - 100)
					result = sum;
				else if (100 - (sum - n) < sum - 100)
					result = sum - n;
				break;
			}
		}
		if (i == 10)
			result = sum;
		System.out.println(result);
	}
}
