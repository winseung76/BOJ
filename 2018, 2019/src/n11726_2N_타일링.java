import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11726_2N_≈∏¿œ∏µ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long n = Integer.parseInt(br.readLine());
		long[] arr = new long[(int) (n + 1)];

		for (int i = 1; i < n + 1; i++) {
			if (i == 1)
				arr[i] = 1;
			else if (i == 2)
				arr[i] = 2;
			else
				arr[i] = arr[i - 1] + arr[i - 2];

			arr[i] %= 10007;
		}
		long result = arr[(int) n] % (long) 10007;
		bw.write(result + "\n");
		bw.flush();

	}
}
