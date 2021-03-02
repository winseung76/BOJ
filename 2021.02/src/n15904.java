import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n15904 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		int idx = 0;
		boolean flag = true;
		char[] arr = { 'U', 'C', 'P', 'C' };
		int i = 0;

		while (i < 4) {

			int nIdx = str.indexOf(arr[i++], idx);

			if (nIdx == -1) {
				flag = false;
				break;
			}

			idx = nIdx + 1;
		}

		if (flag)
			bw.write("I love UCPC\n");
		else
			bw.write("I hate UCPC\n");

		bw.flush();

	}

}
