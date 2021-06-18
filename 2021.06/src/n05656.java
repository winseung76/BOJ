import java.io.*;

public class n05656 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int idx = 1;

		while (true) {

			String str = br.readLine();

			if (str.contains("E"))
				break;

			String[] input = str.split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[2]);

			if (str.contains(">=")) {
				if (a >= b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			else if (str.contains(">")) {
				if (a > b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			else if (str.contains("<=")) {
				if (a <= b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			else if (str.contains("<")) {
				if (a < b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			else if (str.contains("==")) {
				if (a == b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			else if (str.contains("!=")) {
				if (a != b)
					bw.write("Case " + idx + ": true\n");
				else
					bw.write("Case " + idx + ": false\n");
			}

			idx++;

		}

		bw.flush();

	}

}
