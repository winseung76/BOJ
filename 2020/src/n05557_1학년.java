import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n05557_1�г� {

	static long[][] dp = new long[100][21]; // n��° ��� �ÿ� ������ �� �ִ� �����
	static short[] arr; // �Է��� ������ ����
	static long res;    // ���� ���
	static int ans;     // �Է��� ���� �� ������ �� = �� ���������� ������ �͵��� ����� �Ǿ���ϴ� ��

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		arr = new short[N];

		String[] s = br.readLine().split(" ");

		for (int i = 0; i < N; i++)
			arr[i] = Short.parseShort(s[i]);

		ans = arr[N - 1]; // �Է��� ���� �� ������ ��

		dp[0][arr[0]] = 1;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j <= 20; j++) {

				if (dp[i - 1][j] > 0) {
					int p = j + arr[i];
					int m = j - arr[i];

					if (0 <= p && p <= 20)
						dp[i][p] += dp[i - 1][j];
					if (0 <= m && m <= 20)
						dp[i][m] += dp[i - 1][j];
				}
			}
		}
		res = dp[N - 2][ans];

		bw.write(res + "\n");
		bw.flush();
	}
}
