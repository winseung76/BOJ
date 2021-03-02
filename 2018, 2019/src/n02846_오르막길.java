import java.util.Scanner;

public class n02846_�������� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int pre_num = sc.nextInt();
		int start = pre_num;
		int end = pre_num;
		int max = end - start;

		for (int i = 0; i < size - 1; i++) {
			int num = sc.nextInt();
			int diff = num - pre_num;

			if (diff <= 0) { // diff�� 0���� ���� ���
				start = num;
				end = num;
			} else {
				end = num;
				max = Math.max(max, end - start);
			}
			pre_num = num;
		}
		System.out.println(max);

	}
}
