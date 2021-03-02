import java.util.Scanner;

public class n02903_중앙_이동_알고리즘 {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();

		long result = ((long) Math.pow(2, N) + 1) * ((long) Math.pow(2, N) + 1);
		System.out.println(result);

	}
}
