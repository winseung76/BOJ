import java.io.*;

public class n01408 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(":");
		int sh = Integer.parseInt(input[0]);
		int sm = Integer.parseInt(input[1]);
		int ss = Integer.parseInt(input[2]);

		int start = ss + sm * 60 + sh * 3600;

		input = br.readLine().split(":");
		int eh = Integer.parseInt(input[0]);
		int em = Integer.parseInt(input[1]);
		int es = Integer.parseInt(input[2]);

		int end = es + em * 60 + eh * 3600;

		if (start > end) {
			end += 24 * 3600;
		}

		int time = end - start;

		int rs = time % 60;
		int rm = time % 3600 / 60;
		int rh = time / 3600;

		String res = String.format("%02d", rh) + ":" + String.format("%02d", rm) + ":" + String.format("%02d", rs);

		bw.write(res + "\n");
		bw.flush();

	}

}
