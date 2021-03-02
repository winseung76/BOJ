import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01453 {

	static int N;
	static boolean[] arr = new boolean[101];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		String[] sarr = br.readLine().split(" ");

		int cnt = 0;

		for (int i = 0; i < sarr.length; i++) {
			int n = Integer.parseInt(sarr[i]);

			if (arr[n])
				cnt++;
			else
				arr[n] = true;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

}
