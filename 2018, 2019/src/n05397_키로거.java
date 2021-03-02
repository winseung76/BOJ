import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class n05397_Å°·Î°Å {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Character> res = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int index = 0;
			res.clear();

			for (int j = 0; j < s.length(); j++) {
				char ch = s.charAt(j);

				switch (ch) {
				case '<':
					index--;
					index = Math.max(0, index);
					break;
				case '>':
					index++;
					index = Math.min(res.size(), index);
					break;
				case '-':
					index--;
					if (res.size() > index && index >= 0)
						res.remove(index);

					index = Math.max(0, index);
					break;
				default:
					res.add(index++, ch);
				}

			}

			for (int j = 0; j < res.size(); j++)
				bw.write(res.get(j));

			bw.write("\n");
			bw.flush();
		}

	}
}
