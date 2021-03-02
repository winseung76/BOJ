import java.util.Hashtable;
import java.util.Scanner;

public class n09442_SortMe {
	private static Hashtable database = new Hashtable();

	public static void main(String[] args) {

		int size;
		int count = 0;

		String[] strings;
		Scanner sc = new Scanner(System.in);

		while (true) {
			size = sc.nextInt();
			if (size == 0)
				break;
			String order = sc.nextLine();

			for (int i = 0; i < order.length(); i++) {
				database.put(order.charAt(i), i);
			}
			strings = new String[size];

			for (int k = 0; k < size; k++) {
				strings[k] = sc.nextLine();
			}

			// 차례대로 입력받은 문자열을 정렬한다.
			sort(strings, size);
			System.out.println("year " + (++count));

			for (int i = 0; i < size; i++) {
				System.out.println(strings[i]);
			}
		}

	}

	// 임의의 알파벳 순서를 기준으로 두 단어를 비교하는 메소드
	// 받아들인 두 개의 단어 중에서 오른쪽의 단어의 순서가 더 앞인 경우 1을,
	// 왼쪽의 단어의 순서가 더 앞인 경우 -1을, 두 단어의 순서가 같은 경우 0을 반환하였다.

	// 이는 기존의 메소드인 compareTo()를 응용하여 만든 메소드이다.
	public static int compareString(String a, String b) {

		if (a.equals(b))
			return 0;

		for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
			int order_a = (int) database.get(a.charAt(i));
			int order_b = (int) database.get(b.charAt(i));

			if (order_a < order_b)
				return -1;
			else if (order_a > order_b)
				return 1;
		}

		if (a.length() < b.length())
			return -1;
		else
			return 1;

	}

	// 문자열을 오름차순으로 정렬하는 메소드
	// 버블 정렬을 이용하여 왼쪽부터 차례대로 나란한 두 단어를 비교하여 정해진 순서에 따라 오름차순으로 정렬한다.
	public static void sort(String[] data, int size) {

		// 버블 정렬 이용
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - 1 - i; j++) {
				if (compareString(data[j], data[j + 1]) > 0) {
					String tmp = data[j];
					data[j] = data[j + 1];
					data[j + 1] = tmp;
				}
			}
		}
	}
}
