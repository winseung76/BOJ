import java.io.*;

public class n09243 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String str1 = br.readLine();
		String str2 = br.readLine();

		boolean flag = true;

		if (N % 2 == 0) {

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) != str2.charAt(i)) {
					flag = false;
					break;
				}
			}
		}

		else {
			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == str2.charAt(i)) {
					flag = false;
					break;
				}
			}
		}

		if (flag)
			bw.write("Deletion succeeded\n");
		else
			bw.write("Deletion failed\n");

		bw.flush();

	}

}
