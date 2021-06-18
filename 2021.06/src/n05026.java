import java.io.*;

public class n05026 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			if (str.equals("P=NP")) {
				bw.write("skipped\n");
			} else {
				String[] input = str.split("\\+");
				int a = Integer.parseInt(input[0]);
				int b = Integer.parseInt(input[1]);
				bw.write((a + b) + "\n");
			}
		}
		bw.flush();

	}

}
