import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class n02822_점수계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		TreeMap<Integer, Integer> map = new TreeMap<>();

		for (int i = 0; i < 8; i++)
			map.put(sc.nextInt(), i + 1);

		int sum = 0;
		int count = 0;
		for (Integer n : map.keySet()) {
			if (count >= 3) {
				sum += n;
				arr[count - 3] = map.get(n);
			}
			count++;
		}
		Arrays.sort(arr);
		System.out.println(sum);
		for (int i = 0; i < 5; i++)
			System.out.print(arr[i] + " ");

	}
}
