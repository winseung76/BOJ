import java.util.Scanner;

public class n02909_Äµµð±¸¸Å {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long C = sc.nextLong();
		int K = sc.nextInt();
		long rest = C % (long) Math.pow(10, K);

		if (rest < 5 * Math.pow(10, K - 1))
			System.out.println(C - rest);
		else
			System.out.println(C + (long) Math.pow(10, K) - rest);

	}
}
