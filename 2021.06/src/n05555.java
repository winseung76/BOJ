import java.io.*;

public class n05555 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();

		int cnt = 0;

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			str += str;

			if (str.contains(s))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

}
