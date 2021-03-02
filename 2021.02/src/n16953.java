import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n16953 {

	static int A, B;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");

		A = Integer.parseInt(sarr[0]);
		B = Integer.parseInt(sarr[1]);

		int n = B;
		int cnt = 0;

		while (n > A) {

			if (n % 2 > 0 && n % 10 != 1) {
				cnt = -1;
				break;
			}
			
			if (n % 2 == 0)
				n = n / 2;
			else
				n = (n - 1) / 10;

			cnt++;
		}
		if (n == A)
			cnt += 1;
		else
			cnt = -1;

		bw.write(cnt + "\n");
		bw.flush();

	}

}
