import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class n09251_LCS {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();
		ArrayList<Integer>[] dp = new ArrayList[s2.length()];
		ArrayList<Integer>[] index1 = new ArrayList[s2.length()];
		ArrayList<Integer>[] index2 = new ArrayList[s2.length()];
		int result = 0;

		for (int i = 0; i < s2.length(); i++) {
			String p1 = s1.substring(i, i + 1);

			for (int j = 0; j < index1[i - 1].size(); j++) {

				int pos1 = s1.indexOf(p1, index1[i - 1].get(j) + 1);
				int pos2 = s2.indexOf(p1, index2[i - 1].get(j) + 1);

				if (pos1 != -1 && pos2 != -1) {
					index1[i].add(pos1);
					index2[i].add(pos2);
					dp[i].add(dp[i - 1].get(j) + 1);
				} else {
					index1[i].add(index1[i].get(j));
					index2[i].add(index2[i].get(j));
					dp[i].add(dp[i - 1].get(j));
				}
			}
		}
		int max = -1;
		for (int i = 0; i < dp[s2.length() - 1].size(); i++) {
			max = Math.max(max, dp[s2.length() - 1].get(i));
		}

		bw.write(max + "\n");
		bw.flush();
	}
}
