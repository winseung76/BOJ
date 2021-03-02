import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n01543_문서검색 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String s = br.readLine();
		int cnt = 0;

		int index = str.indexOf(s, 0);
		for (int i = index; i < str.length();) {
			index = str.indexOf(s, i);
			if (index < 0)
				break;
			i = index + s.length();
			cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();
	}
}
