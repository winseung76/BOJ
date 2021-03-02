import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10807 {

	static int[] arr = new int[201];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(sarr[i]);
			arr[n + 100]++;
		}
		int v = Integer.parseInt(br.readLine());
		bw.write(arr[v + 100] + "\n");
		bw.flush();

	}

}
