import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10162 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] arr = { 300, 60, 10 };
		int[] ans = new int[3];

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < 3; i++) {

			ans[i] = N / arr[i];

			N = N % arr[i];

		}
		if (N > 0 || ans[0] == 0 && ans[1] == 0 && ans[2] == 0)
			bw.write(-1 + "\n");
		else {
			bw.write(ans[0] + " " + ans[1] + " " + ans[2] + "\n");
		}
		bw.flush();

	}

}
