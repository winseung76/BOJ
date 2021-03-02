import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10989_수정렬하기3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[10000];

		for (int i = 0; i < size; i++) {
			arr[Integer.parseInt(br.readLine()) - 1]++;
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 10000; i++) {
			if (arr[i] > 0) {
				for (int j = 0; j < arr[i]; j++)
					bw.write((i + 1) + "\n");
			}
		}
		br.close();
		bw.close();

	}
}
