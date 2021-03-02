import java.util.Scanner;

public class n01026_º¸¹° {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] a, b;

		int size = sc.nextInt();
		a = new int[size];
		b = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < size; i++) {
			b[i] = sc.nextInt();
		}
		bubble_sort(a, 'a');
		bubble_sort(b, 'd');
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += a[i] * b[i];
		}
		System.out.println(sum);

	}

	public static void bubble_sort(int[] arr, char c) {
		boolean con = false;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (c == 'a')
					con = arr[j] > arr[j + 1];
				else if (c == 'd')
					con = arr[j] < arr[j + 1];
				if (con) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
	}
}
