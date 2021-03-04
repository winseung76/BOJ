import java.io.*;

public class n01541 {

	static int res;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		String[] front, back = null;

		int idx = str.indexOf('-');
		if (idx > -1) {
			front = str.substring(0, idx).split("\\+");
			back = str.substring(idx + 1).replace("+", "-").split("\\-");
		} else
			front = str.split("\\+");

		for (int i = 0; i < front.length; i++) {
			res += Integer.parseInt(front[i]);
		}
		if (back != null) {
			for (int i = 0; i < back.length; i++) {
				res -= Integer.parseInt(back[i]);
			}
		}

		bw.write(res + "\n");
		bw.flush();
	}
}
