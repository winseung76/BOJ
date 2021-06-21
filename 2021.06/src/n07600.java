import java.io.*;
import java.util.*;

public class n07600 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		while (!(str = br.readLine()).equals("#")) {

			HashSet<Character> set = new HashSet<>();

			str = str.toLowerCase();

			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);

				if ('a' <= ch && ch <= 'z')
					set.add(ch);
			}

			bw.write(set.size() + "\n");

		}
		bw.flush();

	}

}
