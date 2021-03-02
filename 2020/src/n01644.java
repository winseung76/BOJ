import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class n01644 {

	static int N;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		list.add(2);
		list.add(3);

		boolean flag;
		for (int i = 5; i <= N; i += 2) {
			flag = false;
			for (int j = 0; list.get(j) * list.get(j) <= i; j++) {
				if (i % list.get(j) == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				list.add(i);
		}

		bw.write(getCount() + "\n");
		bw.flush();

	}

	public static int getCount() {

		int s = 0, e = 0;
		int sum = 0;
		int cnt = 0;
		int size = list.size();

		while (s < size) {

			if (sum == N) {
				sum -= list.get(s++);
				cnt++;
			} else if (sum > N || e == size)
				sum -= list.get(s++);
			else if (sum < N)
				sum += list.get(e++);

		}
		return cnt;

	}

}
