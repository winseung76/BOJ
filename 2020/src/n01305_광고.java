import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01305_±¤°í {

	static int L;
	static char[] arr;
	static int[] pi;
	static int min = 1;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		L = Integer.parseInt(br.readLine());
		arr = br.readLine().toCharArray();
		pi = new int[L];

		getPi();

		min=L-pi[L-1];
		bw.write(min + "\n");
		bw.flush();
	}

	static void getPi() {

		int begin = 1;
		int m = 0;

		while (begin + m < L) {
			if (arr[begin + m] == arr[m]) {
				m++;
				pi[begin + m - 1] = m;
			} else {
				if (m == 0)
					begin++;
				else {
					begin += (m - pi[m - 1]);
					m = pi[m - 1];
				}
			}
		}
	}
}
