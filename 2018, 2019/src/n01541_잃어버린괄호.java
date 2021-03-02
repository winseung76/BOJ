import java.util.Scanner;
import java.util.StringTokenizer;

public class n01541_ÀÒ¾î¹ö¸°°ýÈ£ {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringTokenizer st;

		int result = 0;

		String[] arr = str.split("-");

		for (int i = 0; i < arr.length; i++) {
			int n;
			if (arr[i].contains("+")) {
				int sum = 0;
				st = new StringTokenizer(arr[i], "+");
				while (st.hasMoreTokens()) {
					sum += Integer.parseInt(st.nextToken());
				}
				n = sum;
			} else
				n = Integer.parseInt(arr[i]);

			if (i == 0)
				result = n;
			else
				result -= n;
		}
		System.out.println(result);

	}
}
