import java.util.Scanner;

public class n02810_��Ȧ�� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int cnt = 0;
		int l_cnt = 0;
		boolean left = true; // ���� ��Ȧ�� ��� �����ϴٴ� �ǹ�
		String str = sc.next();
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);

			if (c == 'S')
				cnt++;
			else if (c == 'L') {
				if (l_cnt == 0) {
					if (left) {
						cnt++;
						left = false;
					}
					l_cnt++;
				} else {
					l_cnt = 0;
					cnt++;
				}

			}
		}
		System.out.println(cnt);

	}
}
