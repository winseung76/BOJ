import java.util.Arrays;
import java.util.Scanner;

public class n05543_상근날드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] hanbugar = new int[3];
		int[] drink = new int[2];

		for (int i = 0; i < 3; i++)
			hanbugar[i] = sc.nextInt();
		Arrays.sort(hanbugar);
		for (int i = 0; i < 2; i++)
			drink[i] = sc.nextInt();
		Arrays.sort(drink);

		System.out.println(hanbugar[0] + drink[0] - 50);
	}
}
