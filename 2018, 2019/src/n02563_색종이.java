import java.util.Arrays;
import java.util.Scanner;

public class n02563_»öÁ¾ÀÌ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Square[] arr = new Square[N];

		for (int i = 0; i < N; i++)
			arr[i] = new Square(sc.nextInt(), sc.nextInt());

		Arrays.sort(arr);
		int area, result = 100;
		for (int i = 1; i < N; i++) {
			area = 0;
			if (arr[i - 1].b >= arr[i].b) {
				area = (arr[i - 1].a + 10 - arr[i].a) * (arr[i].b + 10 - arr[i - 1].b);
			}
			result += 100 - area;
		}
		System.out.println(result);
	}
}

class Square implements Comparable {
	int a, b;

	Square(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public int compareTo(Object o) {

		return a - ((Square) o).a;
	}
}