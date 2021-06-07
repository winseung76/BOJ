import java.io.*;

public class n02530 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int hour = Integer.parseInt(input[0]);
		int min = Integer.parseInt(input[1]);
		int sec = Integer.parseInt(input[2]);

		int sum = sec + min * 60 + hour * 3600;

		sum += Integer.parseInt(br.readLine());

		int r1 = sum / 3600;
		int r2 = sum % 3600 / 60;
		int r3 = sum % 60;

		bw.write(r1 % 24 + " " + r2 % 60 + " " + r3 % 60);
		bw.flush();

	}

}
