import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n09507_Generations_of_Tribbles {

	static long[] dp = new long[68];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		dp[0] = dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4];
		}

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n] + "\n");
		}
		bw.flush();

	}

}
