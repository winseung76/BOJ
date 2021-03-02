import java.io.*;

public class n10821 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] str = br.readLine().split(",");

		bw.write(str.length + "\n");
		bw.flush();

	}

}
