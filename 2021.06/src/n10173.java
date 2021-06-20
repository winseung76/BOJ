import java.io.*;

public class n10173 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		while (!(str = br.readLine()).equals("EOI")) {
			str = str.toLowerCase();

			if (str.contains("nemo")) {
				bw.write("Found\n");
			} else
				bw.write("Missing\n");
		}
		bw.flush();

	}

}
