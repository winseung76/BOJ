import java.util.Scanner;

public class n05554_�ɺθ�_����_�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			sum += sc.nextInt();
		}
		int min = sum / 60;
		int sec = sum % 60;
		System.out.println(min + "\n" + sec);

	}
}
