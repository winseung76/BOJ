import java.io.*;

public class n02064 {

	static int n, m;
	static String[] sarr;
	static String ip = "";
	static String mask = "";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		sarr = new String[n];

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split("\\.");
			changeByte(input, i);
		}

		m = getM();
		getIP();
		getMask();

		bw.write(ip + "\n");
		bw.write(mask + "\n");
		bw.flush();

	}

	public static void changeByte(String[] input, int idx) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(input[i]);

			StringBuilder tmp = new StringBuilder();

			for (int j = 0; j < 8; j++) {
				tmp.append(n % 2);
				n = n / 2;
			}

			sb.append(tmp.reverse());
		}

		sarr[idx] = sb.toString();

	}

	public static int getM() {

		int cnt = 0;

		for (int i = 0; i < 32; i++) {

			char ch = sarr[0].charAt(i);

			for (int j = 1; j < n; j++) {
				if (sarr[j].charAt(i) != ch) {
					return 32 - cnt;
				}
			}

			cnt++;
		}

		return 32 - cnt;
	}

	public static void getIP() {

		String ipByte = sarr[0];

		ipByte = ipByte.substring(0, sarr[0].length() - m);
		for (int j = 0; j < m; j++) {
			ipByte += "0";
		}
		int start = 0;
		for (int i = 0; i < 4; i++) {

			String str = ipByte.substring(start, start + 8);
			int f = 1;
			int num = 0;

			for (int j = 7; j >= 0; j--) {
				if (str.charAt(j) == '1') {
					num += f;
				}
				f *= 2;
			}

			if (i < 3)
				ip += num + ".";
			else
				ip += num;

			start += 8;
		}

	}

	public static void getMask() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 32 - m; i++) {
			sb.append("1");
		}

		for (int i = 0; i < m; i++) {
			sb.append("0");
		}

		String maskByte = sb.toString();

		int start = 0;
		for (int i = 0; i < 4; i++) {

			String str = maskByte.substring(start, start + 8);
			int f = 1;
			int num = 0;

			for (int j = 7; j >= 0; j--) {
				if (str.charAt(j) == '1') {
					num += f;
				}
				f *= 2;
			}

			if (i < 3)
				mask += num + ".";
			else
				mask += num;

			start += 8;
		}
	}

}
