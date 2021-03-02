import java.util.Scanner;

public class n02799_ºñ¹Ð¾î {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] state = new int[5];
		int window_num = n;
		for (int i = 0; i < 5 * m + 1; i++) {
			int rest = i % 5;
			String str = sc.next();

			if (rest == 0) {
				if (window_num != n)
					state[4] += n - window_num;
				window_num = 0;
			}

			else {
				if (str.contains("....")) {
					int count = get_count(str);
					if (window_num != 0) {
						state[rest - 1] += count - window_num;
						window_num += count - window_num;
					} else {
						state[rest - 1] += count;
						window_num += count;
					}

				}
			}
		}
		for (int i = 0; i < 5; i++)
			System.out.print(state[i] + " ");
	}

	public static int get_count(String str) {
		int org_size = str.length();

		str = str.replace("....", "");

		int new_size = str.length();

		return (org_size - new_size) / 4;
	}
}
