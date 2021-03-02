import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n06549_히스토그램에서_가장_큰_직사각형 {
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long max;

		try {
			String str;

			while (!(str = br.readLine()).equals("0")) {
				String[] arr = str.split(" ");
				max = Integer.MIN_VALUE;

				for (int i = 0; i < arr.length; i++) {
					long n = Integer.parseInt(arr[i]);
					long h = n;

					for (int j = i; j >= 0; j--) {
						h = Math.min(Integer.parseInt(arr[j]), h);
						long w = i - j + 1;

						max = Math.max(max, w * h);

					}
				}
				bw.write(max + "\n");
				bw.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
