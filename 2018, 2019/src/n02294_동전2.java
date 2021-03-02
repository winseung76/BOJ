import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class n02294_µ¿Àü2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int n = sc.nextInt();
		int k = sc.nextInt();
		TreeSet<Integer> coin = new TreeSet<>();
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coin.add(sc.nextInt());
		}

		for (int i = 1; i < k + 1; i++) {
			flag = false;
			Iterator it = coin.iterator();
			while (it.hasNext()) {
				if (i == (int) it.next()) {
					dp[i] = 1;
					flag = true;
					break;
				}
			}

			if (!flag) {
				it = coin.iterator();
				while (it.hasNext()) {
					int c = (int) it.next();
					if (i > c && dp[i - c] != 0) {
						if (dp[i] != 0)
							dp[i] = Math.min(dp[i], dp[i - c] + 1);
						else
							dp[i] = dp[i - c] + 1;
					}
				}
			}
		}
		if (dp[k] == 0)
			dp[k] = -1;
		System.out.println(dp[k]);
	}
}
