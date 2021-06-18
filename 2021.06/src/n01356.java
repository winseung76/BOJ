import java.io.*;

public class n01356 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		for (int i = 1; i < str.length(); i++) {
			String front = str.substring(0, i);
			String rear = str.substring(i);
			long num1 = 1;
			long num2 = 1;

			for (int j = 0; j < front.length(); j++) {
				int n = front.charAt(j) - '0';
				num1 *= n;
			}

			for (int j = 0; j < rear.length(); j++) {
				int n = rear.charAt(j) - '0';
				num2 *= n;
			}

			if (num1 == num2) {
				bw.write("YES\n");
				bw.flush();
				return;
			}
		}

		bw.write("NO\n");
		bw.flush();

	}

}
