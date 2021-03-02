import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n03003 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] ans = { 1, 1, 2, 2, 2, 8 };
		String[] sarr = br.readLine().split(" ");

		for (int i = 0; i < sarr.length; i++) {
			int n = Integer.parseInt(sarr[i]);
			bw.write(ans[i] - n + " ");
		}
		bw.flush();

	}

}
