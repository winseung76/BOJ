import java.io.*;

public class n01284 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {

			String str = br.readLine();

			if (str.equals("0"))
				break;

			int sum = 1;

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (ch == '1')
					sum += 2;
				else if (ch == '0')
					sum += 4;
				else
					sum += 3;

				sum++;
			}

			bw.write(sum + "\n");
		}
		bw.flush();

	}

}
