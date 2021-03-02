import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class n02960_에라토스테네스의_체 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList();
		int N = sc.nextInt();
		int K = sc.nextInt();

		for (int i = 2; i <= N; i++)
			list.add(i);

		int count = 0;
		int ans = 0;
		while (!list.isEmpty()) {
			Collections.sort(list);
			int min = list.get(0);

			for (int i = min; i <= N; i++) {
				if (list.contains(i) && i % min == 0) {

					list.remove((Object) i);
					count++;
					if (count == K) {
						ans = i;
					}
				}
			}
			if (ans != 0) {
				System.out.println(ans);
				break;
			}
		}
	}
}
