import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class n02992_크면서작은수 {
	private static char[] arr;
	private static String X;
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		X = sc.nextLine();
		arr = X.toCharArray();

		dfs();

		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);

	}

	public static void dfs() {

		String tmp = "";
		ArrayList<Character> rest;
		char[] r;

		for (int i = arr.length - 2; i >= 0; i--) {
			int org = arr[i] - '0';
			tmp = X.substring(0, i);
			int size = tmp.length();
			rest = new ArrayList<>();
			r = X.substring(i + 1, arr.length).toCharArray();
			Arrays.sort(r);

			boolean flag = false;
			for (int j = 0; j < r.length; j++) {
				int new_n = r[j] - '0';
				if (new_n > org && !flag) {
					tmp = tmp + r[j];
					flag = true;
				} else
					rest.add(r[j]);

			}
			if (tmp.length() > size)
				rest.add(arr[i]);
			else
				tmp = tmp + arr[i];

			Collections.sort(rest);

			for (int j = 0; j < rest.size(); j++)
				tmp = tmp + rest.get(j);

			if (Integer.parseInt(X) < Integer.parseInt(tmp))
				min = Math.min(min, Integer.parseInt(tmp));
		}

	}
}
