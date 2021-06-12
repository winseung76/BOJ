import java.io.*;

public class n14487 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		int max = 0;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(input[i]);
			max = Math.max(max, num);
			sum += num;
		}

		sum -= max;

		bw.write(sum + "\n");
		bw.flush();

	}

}
