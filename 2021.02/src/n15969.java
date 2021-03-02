import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15969 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] sarr = br.readLine().split(" ");

		int min = Integer.MAX_VALUE;
		int max = 0;

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(sarr[i]);

			min = Math.min(min, n);
			max = Math.max(max, n);
		}

		bw.write((max - min) + "\n");
		bw.flush();

	}

}
