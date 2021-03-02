import java.util.ArrayList;
import java.util.Scanner;

public class n01722_�����Ǽ��� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		long[] fact = new long[N + 1];
		int n = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			list.add(i);
			if (i == 1)
				fact[i] = 1;
			else
				fact[i] = fact[i - 1] * i;
		}

		if (n == 1) {
			long K = sc.nextLong();

			int tmp_n = N;

			while (list.size() > 1) {
				for (int i = 1; i <= tmp_n; i++) {
					if (K <= fact[tmp_n - 1] * i) {
						System.out.print(list.get(i - 1) + " ");
						list.remove(i - 1); // �̹� ��µ� ���ڴ� ����Ʈ���� �����. �ٽ� ���� ������� �������� ���ִ� ����
						K = K - fact[tmp_n - 1] * (i - 1); // 9!*1 ~ 9!*2 ���̿� K�� �ִٸ� K���� 9!*1�� �A��.
															// �ٽ� 9!*1������ ������ �����غ��� ����
						tmp_n = tmp_n - 1;
						break;
					}
				}
			}

			System.out.print(list.get(0));

		} else if (n == 2) {
			long order = 1;
			int tmp_n = N;

			for (int i = 0; i < N - 1; i++) { // ������ ���ڴ� �ڵ����� �����Ǵ� N-1������ �õ��ص� ��
				int num = sc.nextInt();
				int index = list.indexOf(num);
				order += fact[tmp_n - 1] * index;
				list.remove((Object) num);
				tmp_n = tmp_n - 1;
			}
			System.out.println(order);
		}
	}
}
