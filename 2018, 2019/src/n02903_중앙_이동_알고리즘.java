import java.util.Scanner;

public class n02903_�߾�_�̵�_�˰��� {
	public static void main(String[] args) {
		int N = new Scanner(System.in).nextInt();

		long result = ((long) Math.pow(2, N) + 1) * ((long) Math.pow(2, N) + 1);
		System.out.println(result);

	}
}
