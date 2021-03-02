import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Vector;

public class n05430 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			String p = br.readLine();

			int n = Integer.parseInt(br.readLine());
			Vector<String> list = new Vector<>();

			String str = br.readLine().replace("[", "").replace("]", "");

			if (str.length() > 0)
				Collections.addAll(list, str.split(","));

			boolean flag = false;
			boolean reverse = false;
			int start = 0;
			int end = list.size() - 1;

			for (int i = 0; i < p.length(); i++) {
				char ch = p.charAt(i);

				if (ch == 'R')
					reverse = (reverse ? false : true);

				else if (ch == 'D') {
					if (start > end) {
						bw.write("error\n");
						flag = true;
						break;
					} else {
						if (reverse)
							end--;
						else
							start++;
					}

				}
			}

			if (!flag) {
				bw.write("[");
				if (reverse) {
					for (int i = end; i >= start; i--) {
						bw.write(list.get(i) + "");
						if (i > start)
							bw.write(",");
					}
				} else {
					for (int i = start; i <= end; i++) {
						bw.write(list.get(i) + "");
						if (i < end)
							bw.write(",");
					}
				}
				bw.write("]\n");
			}

		}
		bw.flush();

	}

}
