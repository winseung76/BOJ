import java.io.*;
import java.util.*;

public class n02966 {

	static char[] arr1 = { 'A', 'B', 'C' };
	static char[] arr2 = { 'B', 'A', 'B', 'C' };
	static char[] arr3 = { 'C', 'C', 'A', 'A', 'B', 'B' };
	static int cnt1, cnt2, cnt3;
	static int idx1, idx2, idx3;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);

			if (arr1[idx1] == ch)
				cnt1++;
			if (arr2[idx2] == ch)
				cnt2++;
			if (arr3[idx3] == ch)
				cnt3++;

			idx1 = (idx1 + 1) % 3;
			idx2 = (idx2 + 1) % 4;
			idx3 = (idx3 + 1) % 6;
		}

		int max = Math.max(cnt1, Math.max(cnt2, cnt3));

		bw.write(max + "\n");

		if (cnt1 == max)
			bw.write("Adrian\n");
		if (cnt2 == max)
			bw.write("Bruno\n");
		if (cnt3 == max)
			bw.write("Goran\n");

		bw.flush();

	}

}
