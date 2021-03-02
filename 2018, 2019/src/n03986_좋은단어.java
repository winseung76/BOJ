import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class n03986_좋은단어 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack stack = new Stack();

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			stack.clear();
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (!stack.isEmpty() && (char) stack.peek() == c)
					stack.pop();
				else
					stack.push(c);
			}
			if (stack.isEmpty())
				count++;
		}
		bw.write(count + "\n");
		bw.flush();

	}
}
