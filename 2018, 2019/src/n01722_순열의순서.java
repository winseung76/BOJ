import java.util.ArrayList;
import java.util.Scanner;

public class n01722_순열의순서 {
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
						list.remove(i - 1); // 이미 출력된 숫자는 리스트에서 지운다. 다시 작은 순서대로 오름차순 되있는 상태
						K = K - fact[tmp_n - 1] * (i - 1); // 9!*1 ~ 9!*2 사이에 K가 있다면 K에서 9!*1을 뺸다.
															// 다시 9!*1이후의 순서를 추정해보기 위해
						tmp_n = tmp_n - 1;
						break;
					}
				}
			}

			System.out.print(list.get(0));

		} else if (n == 2) {
			long order = 1;
			int tmp_n = N;

			for (int i = 0; i < N - 1; i++) { // 마지막 숫자는 자동으로 결정되니 N-1번까지 시도해도 됨
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
