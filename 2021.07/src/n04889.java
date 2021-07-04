import java.io.*;
import java.util.*;

public class n04889 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		int num = 1;

		while (!(str = br.readLine()).contains("-")) {

			Stack<Character> stack = new Stack<>();
			int cnt = 0;

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if (ch == '{') {
					stack.push(ch);
				}

				else if (ch == '}') {
					if (stack.isEmpty()) {
						cnt++;
						stack.push('{');
					}

					else {
						stack.pop();
					}
				}
			}

			cnt += stack.size() / 2;

			bw.write(num + ". " + cnt + "\n");
			num++;
		}
		bw.flush();
	}

}
