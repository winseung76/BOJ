import java.io.*;

public class n11098 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int p = Integer.parseInt(br.readLine());
			int max = 0;
			String res = "";

			for (int j = 0; j < p; j++) {
				String[] input = br.readLine().split(" ");
				int price = Integer.parseInt(input[0]);
				String name = input[1];

				if (price > max) {
					max = price;
					res = name;
				}
			}

			bw.write(res + "\n");

		}
		bw.flush();

	}

}
