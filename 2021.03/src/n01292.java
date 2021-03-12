import java.io.*;

public class n01292 {

	static int[] arr = new int[10001];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 1;
		int i = 1;
		while (i <= 1000) {
			for (int j = i; j < i + n; j++)
				arr[j] = n;
			i += n;
			n++;
		}

		String[] sarr = br.readLine().split(" ");
		int A = Integer.parseInt(sarr[0]);
		int B = Integer.parseInt(sarr[1]);

		int sum = 0;
		for (i = A; i <= B; i++)
			sum += arr[i];

		bw.write(sum + "\n");
		bw.flush();

	}

}
