import java.io.*;

public class n14489 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);

		int C = Integer.parseInt(br.readLine());

		if (A + B < 2 * C)
			bw.write((A + B) + "\n");
		else
			bw.write((A + B - 2 * C) + "\n");
		bw.flush();

	}

}
