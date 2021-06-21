import java.io.*;

public class n15813 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int score = 0;

		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);

			score += (int) (ch - 64);
		}

		bw.write(score + "\n");
		bw.flush();

	}

}
