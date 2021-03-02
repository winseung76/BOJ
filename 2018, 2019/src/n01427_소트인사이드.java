import java.util.Scanner;

public class n01427_소트인사이드 {
	public static void main(String[] args) {
		int[] arr;
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		int size = str.length();
		arr = new int[size];
		int n = Integer.parseInt(str);

		for (int i = 0; i < size; i++) {
			arr[i] = n % 10;
			n = n / 10;
		}

		sort(arr, size);
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i]);
		}

	}

	public static void sort(int[] arr, int size) {
		int max, tmp;
		for (int i = 0; i < size - 1; i++) {
			max = i;
			for (int j = i + 1; j < size; j++) {
				if (arr[max] < arr[j])
					max = j;
			}
			tmp = arr[max];
			arr[max] = arr[i];
			arr[i] = tmp;

		}
	}
}
