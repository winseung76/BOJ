import java.io.*;

public class n02670 {

	static int N;
	static double[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		double max = 0;

		for (int s = 0; s < N; s++) {
			double mul = 1;
			for (int i = s; i < N; i++) {
				mul *= arr[i];
				max = Math.max(max, mul);
			}
		}
		bw.write(String.format("%.3f", max) + "\n");
		bw.flush();

	}
}
