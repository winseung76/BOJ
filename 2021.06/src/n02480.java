import java.io.*;

public class n02480 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);

		int res = 0;

		if (a == b && b == c)
			res = 10000 + a * 1000;
		else if (a == b || a == c)
			res = 1000 + a * 100;
		else if (b == c)
			res = 1000 + b * 100;
		else {
			int max = Math.max(a, Math.max(b, c));
			res = max * 100;
		}

		bw.write(res + "\n");
		bw.flush();

	}

}
