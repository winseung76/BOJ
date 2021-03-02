import java.util.Scanner;

public class n04641_Doubles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			String str = sc.nextLine();

			if (str.equals("-1"))
				break;
			String[] arr = str.split(" ");
			int[] i_arr = new int[arr.length - 1];
			int count = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				int n = Integer.parseInt(arr[i]);

				for (int j = 0; j < arr.length - 1; j++) {
					if (Integer.parseInt(arr[j]) == 2 * n)
						count++;
				}
			}
			System.out.println(count);

		}

	}
}
