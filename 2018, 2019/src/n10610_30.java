import java.util.Arrays;
import java.util.Scanner;

public class n10610_30 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] arr = sc.nextLine().toCharArray();
		Arrays.sort(arr);
		StringBuffer buf = new StringBuffer();
		int sum = 0;
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			buf.append(arr[i]);
			if (arr[i] - '0' == 0) {
				count++;
			}
			sum += arr[i] - '0';
		}
		if (sum % 3 == 0 && count > 0)
			System.out.println(buf.toString());
		else
			System.out.println(-1);
	}
}
