import java.util.Scanner;

public class n03460_ÀÌÁø¼ö {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int dec = sc.nextInt();

			int k = 0;
			while (dec > 0) {
				if (dec % 2 == 1)
					System.out.print(k + " ");
				dec = dec / 2;
				k++;
			}
			System.out.println();
		}

	}
}
