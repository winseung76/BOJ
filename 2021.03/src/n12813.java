import java.io.*;

public class n12813 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str1 = br.readLine();
		String str2 = br.readLine();

		StringBuffer[] buf = new StringBuffer[5];
		for (int i = 0; i < 5; i++)
			buf[i] = new StringBuffer();

		for (int i = 0; i < str1.length(); i++) {
			char ch1 = str1.charAt(i);
			char ch2 = str2.charAt(i);

			if (ch1 == '0' && ch2 == '0') {
				buf[0].append("0");
				buf[1].append("0");
				buf[2].append("0");
			}

			else if (ch1 == '1' && ch2 == '1') {
				buf[0].append("1");
				buf[1].append("1");
				buf[2].append("0");

			}

			else {
				buf[0].append("0");
				buf[1].append("1");
				buf[2].append("1");
			}

			buf[3].append((ch1 == '0') ? "1" : "0");
			buf[4].append((ch2 == '0') ? "1" : "0");
		}

		for (int i = 0; i < 5; i++) {
			bw.write(buf[i].toString() + "\n");
		}
		bw.flush();

	}

}
