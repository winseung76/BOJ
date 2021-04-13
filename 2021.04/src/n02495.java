import java.io.*;

public class n02495 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 3; i++) {
			String str = br.readLine();
			int max = 0;
			int cnt = 1;
			for (int j = 1; j < 8; j++) {
				char ch = str.charAt(j);

				if (ch != str.charAt(j - 1)) {
					max = Math.max(max, cnt);
					cnt = 1;
				} else
					cnt++;
			}
			max = Math.max(max, cnt);
			bw.write(max + "\n");
		}

		bw.flush();

	}

}
