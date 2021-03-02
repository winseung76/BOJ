import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02526 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int N = Integer.parseInt(sarr[0]);
		int P = Integer.parseInt(sarr[1]);

		int n = N;
		int[] arr = new int[P + 1];

		int cnt = 0;
		while (cnt <= 1000) {

			n = (n * N) % P;
			arr[n]++;
			cnt++;
		}

		int res = 0;
		for (int i = 0; i <arr.length; i++) {
			if (arr[i] >= 2)
				res++;
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
