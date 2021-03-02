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

			// ���ʴ�� �Է¹��� ���ڿ��� �����Ѵ�.
			sort(strings, size);
			System.out.println("year " + (++count));

			for (int i = 0; i < size; i++) {
				System.out.println(strings[i]);
			}
		}

	}

	// ������ ���ĺ� ������ �������� �� �ܾ ���ϴ� �޼ҵ�
	// �޾Ƶ��� �� ���� �ܾ� �߿��� �������� �ܾ��� ������ �� ���� ��� 1��,
	// ������ �ܾ��� ������ �� ���� ��� -1��, �� �ܾ��� ������ ���� ��� 0�� ��ȯ�Ͽ���.

	// �̴� ������ �޼ҵ��� compareTo()�� �����Ͽ� ���� �޼ҵ��̴�.
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

	// ���ڿ��� ������������ �����ϴ� �޼ҵ�
	// ���� ������ �̿��Ͽ� ���ʺ��� ���ʴ�� ������ �� �ܾ ���Ͽ� ������ ������ ���� ������������ �����Ѵ�.
	public static void sort(String[] data, int size) {

		// ���� ���� �̿�
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
