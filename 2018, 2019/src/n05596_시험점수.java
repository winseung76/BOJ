import java.util.Scanner;

public class n05596_시험점수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		for (int i = 0; i < 2; i++) {
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				sum += sc.nextInt();
			}
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}
}
