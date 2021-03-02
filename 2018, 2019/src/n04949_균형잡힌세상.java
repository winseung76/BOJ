import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n04949_±ÕÇüÀâÈù¼¼»ó {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> s;
		String str;

		while (!(str = br.readLine()).equals(".")) {

			s = new Stack<>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[')
					s.push(c);
				else if (c == ')' || c == ']') {
					if (!s.isEmpty()) {
						char ch = s.peek();
						if ((c == ')' && ch == '(') || (c == ']' && ch == '['))
							s.pop();
						else
							break;
					} else
						s.push(c);
				}
			}

			if (!s.isEmpty())
				bw.write("no\n");
			else
				bw.write("yes\n");
		}
		bw.flush();
	}
}
