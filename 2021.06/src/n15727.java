import java.io.*;

public class n15727 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int r = n / 5;
		int d = n % 5;

		if (d == 0)
			bw.write(r + "\n");
		else
			bw.write((r + 1) + "\n");

		bw.flush();
	}

}
