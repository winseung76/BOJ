import java.io.*;

public class n02502 {

	static int D, K;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		D = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		int n = K / 2 + 1;

		while (true) {
			int a = K;
			int b = n;

			boolean flag = true;
			for (int i = 0; i < D - 2; i++) {
				int tmp = b;
				b = a - b;
				a = tmp;

				if (b > a || b < 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				bw.write(b + "\n");
				bw.write(a + "\n");
				bw.flush();
				return;
			}
			n++;
		}

	}

}
