import java.io.*;
import java.util.*;

public class n03111 {

	static String A, T;
	static Stack<Character> left = new Stack<>();
	static Stack<Character> right = new Stack<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		A = br.readLine();
		T = br.readLine();

		int pl = 0;
		int pr = T.length() - 1;

		while (pl <= pr) {

			while (pl <= pr && pl < T.length()) {

				left.push(T.charAt(pl++));

				// ¾Õ¿¡¼­ »©±â
				if (left.size() >= A.length() && left.peek() == A.charAt(A.length() - 1)) {
					int idx = A.length() - 1;
					boolean flag = true;

					for (int i = left.size() - 1; i >= left.size() - A.length(); i--) {
						if (left.get(i) != A.charAt(idx--)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						for (int i = 0; i < A.length(); i++)
							left.pop();

						break;
					}

				}
			}

			while (pl <= pr && pr < T.length()) {

				right.push(T.charAt(pr--));

				// µÚ¿¡¼­ »©±â
				if (right.size() >= A.length() && right.peek() == A.charAt(0)) {
					int idx = 0;
					boolean flag = true;

					for (int i = right.size() - 1; i >= right.size() - A.length(); i--) {
						if (right.get(i) != A.charAt(idx++)) {
							flag = false;
							break;
						}
					}
					if (flag) {
						for (int i = 0; i < A.length(); i++)
							right.pop();

						break;
					}
				}
			}
		}

		while (!left.isEmpty())
			right.push(left.pop());

		StringBuffer buf = new StringBuffer();

		while (!right.isEmpty())
			buf.append(right.pop());

		while (true) {
			int idx = buf.indexOf(A);
			if (idx < 0)
				break;

			buf.delete(idx, idx + A.length());
		}

		bw.write(buf.toString());
		bw.flush();
	}

}
