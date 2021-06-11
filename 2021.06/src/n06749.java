import java.io.*;

public class n06749 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int res = b + (b - a);
		bw.write(res + "\n");
		bw.flush();

	}

}
