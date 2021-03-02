import java.io.*;
import java.util.*;

public class n01406 {

	static String str;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		str = br.readLine();
		N = str.length();
		M = Integer.parseInt(br.readLine());

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();

		for (int i = 0; i < N; i++)
			left.push(str.charAt(i));

		for (int i = 0; i < M; i++) {
			String[] sarr = br.readLine().split(" ");
			String cmd = sarr[0];

			switch (cmd) {
			case "L":
				if (!left.isEmpty())
					right.push(left.pop());
				break;
			case "D":
				if (!right.isEmpty())
					left.push(right.pop());
				break;
			case "B":
				if (!left.isEmpty())
					left.pop();
				break;
			case "P":
				char ch = sarr[1].charAt(0);
				left.push(ch);
				break;
			}
		}

		StringBuffer buf = new StringBuffer();
		while (!left.isEmpty())
			buf.append(left.pop());

		String res1 = buf.reverse().toString();

		buf = new StringBuffer();
		while (!right.isEmpty())
			buf.append(right.pop());

		String res2 = buf.toString();

		bw.write(res1 + res2 + "\n");
		bw.flush();

	}

}
