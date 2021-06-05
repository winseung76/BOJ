import java.io.*;

public class n09325 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				s += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
			}

			bw.write(s + "\n");
		}

		bw.flush();

	}

}
