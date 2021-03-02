import java.util.Arrays;
import java.util.Scanner;

public class n01931_회의실배정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Meeting[] arr = new Meeting[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
		int count = 1;
		int next_start = arr[n - 1].start;
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i].start < next_start) {
				if (arr[i].time <= next_start - arr[i].start) {
					next_start = arr[i].start;
					count++;
				}
			} else if (arr[i].time == 0)
				count++;
		}
		System.out.println(count);
	}

	static class Meeting implements Comparable {
		int start;
		int end;
		int time;

		Meeting(int start, int end) {
			this.start = start;
			this.end = end;
			this.time = end - start;
		}

		@Override
		public int compareTo(Object o) {
			if (start < ((Meeting) o).start)
				return -1;
			else if (start == ((Meeting) o).start) {
				return time - ((Meeting) o).time;
			} else
				return 1;
		}
	}
}
