import java.util.Scanner;

public class n05575_타임카드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start, end;
		for (int i = 0; i < 3; i++) {
			start = 0;
			end = 0;
			for (int j = 1; j <= 3; j++) {
				start += sc.nextInt() * Math.pow(60, 3 - j);
			}
			for (int j = 1; j <= 3; j++) {
				end += sc.nextInt() * Math.pow(60, 3 - j);
			}
			int diff = end - start;
			for (int j = 1; j <= 3; j++) {
				System.out.print(diff / (int) Math.pow(60, 3 - j) + " ");
				diff = diff % (int) Math.pow(60, 3 - j);
			}
			System.out.println();
		}
	}
}
