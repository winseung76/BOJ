import java.io.*;
import java.util.Arrays;

public class n15781 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");

		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);

		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		input = br.readLine().split(" ");
		for (int i = 0; i < n1; i++) {
			arr1[i] = Integer.parseInt(input[i]);
		}

		input = br.readLine().split(" ");
		for (int i = 0; i < n2; i++) {
			arr2[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		long sum = arr1[arr1.length - 1] + arr2[arr2.length - 1];

		bw.write(sum + "\n");
		bw.flush();

	}

}
