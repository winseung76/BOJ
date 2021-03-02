import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n10769_행복한지슬픈지 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		int happy = 0;
		int sad = 0;

		for (int i = 0; i < s.length();) {
			String str = s.substring(i);
			int index = str.indexOf(":-)");
			if (index != -1) {
				happy++;
				i += index + 3;
			} else
				break;
		}
		for (int i = 0; i < s.length();) {
			String str = s.substring(i);
			int index = str.indexOf(":-(");
			if (index != -1) {
				sad++;
				i += index + 3;
			} else
				break;
		}
		if (happy == 0 && sad == 0)
			bw.write("none\n");
		else if (happy > sad)
			bw.write("happy\n");
		else if (happy < sad)
			bw.write("sad\n");
		else if (happy == sad)
			bw.write("unsure\n");
		bw.flush();
	}
}
