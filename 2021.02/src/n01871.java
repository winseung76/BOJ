import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01871 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split("-");
			String front = arr[0];
			int back = Integer.parseInt(arr[1]);

			int n = 0;
			int p = 0;
			for (int j = 2; j >= 0; j--) {
				char ch = front.charAt(j);

				n += (ch - 'A') * Math.pow(26, p++);
			}

			int diff = Math.abs(n - back);

			if (diff <= 100)
				bw.write("nice\n");
			else
				bw.write("not nice\n");
		}

		bw.flush();

	}

}
