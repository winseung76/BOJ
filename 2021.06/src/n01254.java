import java.io.*;

public class n01254 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		bw.write(solve(str) + "\n");
		bw.flush();

	}

	public static int solve(String str) {

		int len = str.length() - 1;

		for (len = str.length() - 1; len >= 0; len--) {
			String sub = str.substring(str.length() - 1 - len);

			if (isPalindrome(sub)) {
				break;
			}
		}

		return str.length() + (str.length() - len) - 1;

	}

	public static boolean isPalindrome(String str) {

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		}

		return true;
	}

}
