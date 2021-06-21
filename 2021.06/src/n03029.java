import java.io.*;

public class n03029 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(":");
		int start = 0;
		start += Integer.parseInt(input[2]);
		start += Integer.parseInt(input[1]) * 60;
		start += Integer.parseInt(input[0]) * 3600;

		input = br.readLine().split(":");
		int end = 0;
		end += Integer.parseInt(input[2]);
		end += Integer.parseInt(input[1]) * 60;
		end += Integer.parseInt(input[0]) * 3600;

		if (start >= end)
			end += 24 * 3600;

		int diff = end - start;

		int hour = diff / 3600;
		int min = (diff % 3600) / 60;
		int sec = diff % 3600 % 60;

		String str = String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);

		bw.write(str + "\n");
		bw.flush();
	}

}
