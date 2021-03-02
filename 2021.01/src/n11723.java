import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n11723 {

	static int S;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			String cmd = s[0];

			switch (cmd) {

			case "add":
				int n = Integer.parseInt(s[1]);
				add(n);
				break;
			case "remove":
				n = Integer.parseInt(s[1]);
				remove(n);
				break;
			case "check":
				n = Integer.parseInt(s[1]);
				int res = check(n);
				bw.write(res + "\n");
				break;
			case "toggle":
				n = Integer.parseInt(s[1]);
				toggle(n);
				break;
			case "all":
				all();
				break;
			case "empty":
				empty();
				break;
			}

		}
		bw.flush();

	}

	public static void add(int n) {

		S = S | (1 << n);
	}

	public static void remove(int n) {

		S = S & ~(1 << n);
	}

	public static int check(int n) {

		if ((S & (1 << n)) > 0)
			return 1;
		else
			return 0;
	}

	public static void toggle(int n) {

		S = S ^ (1 << n);
	}

	public static void all() {

		S = (1 << 21) - 1;
	}

	public static void empty() {

		S = 0;
	}

}
