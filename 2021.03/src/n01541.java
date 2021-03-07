import java.io.*;

public class n01541 {

	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split("-"); // arr[0] =  "55"  arr[1] = "50+40" -> "90"

		for (int i = 0; i < arr.length; i++) {

			if (arr[i].contains("+")) {
				int sum = 0;
				String[] num = arr[i].split("\\+");
				for (int j = 0; j < num.length; j++) {
					sum += Integer.parseInt(num[j]);
				}
				arr[i] = String.valueOf(sum);
			}
		}

		int res = Integer.parseInt(arr[0]);
		for (int i = 1; i < arr.length; i++)
			res -= Integer.parseInt(arr[i]);

		bw.write(res + "\n");
		bw.flush();

	}
}
