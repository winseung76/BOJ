import java.io.*;

public class n10823 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		StringBuilder sb = new StringBuilder();

		while ((str = br.readLine()) != null) {

			sb.append(str);
		}

		int sum = 0;
		String[] arr = sb.toString().split(",");
		for (int i = 0; i < arr.length; i++) {
			sum += Integer.parseInt(arr[i]);
		}

		bw.write(sum + "\n");
		bw.flush();

	}

}
