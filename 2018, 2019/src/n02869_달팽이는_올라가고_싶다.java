import java.util.Scanner;

public class n02869_�����̴�_�ö󰡰�_�ʹ� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();

		V = V - A;
		int count = 1;
		while (V > 0) {
			V = V - (A - B);
			count++;
		}
		System.out.println(count);
	}
}
