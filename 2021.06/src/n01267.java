import java.io.*;

public class n01267 {

	static int[] m = new int[10001];
	static int[] y = new int[10001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i <= 10000; i++) {
			y[i] = (i / 30 + 1) * 10;
			m[i] = (i / 60 + 1) * 15;
		}

		int N = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int M = 0;
		int Y = 0;

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(input[i]);
			M += m[p];
			Y += y[p];
		}

		if (M < Y)
			bw.write("M " + M);
		else if (M > Y)
			bw.write("Y " + Y);
		else
			bw.write("Y M " + M);

		bw.flush();

	}

}
