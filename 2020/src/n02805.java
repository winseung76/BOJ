import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n02805 {

	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		arr = new int[N];
		s = br.readLine().split(" ");

		int max = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(s[i]);
			max = Math.max(max, arr[i]);
		}

		long res = binSearch(max + 1);
		bw.write(res + "\n");
		bw.flush();

	}
	// pl = pr 일 때, sum > M 이면 별다른 문제없음("적어도" M보다 크다)
	//              sum < M 이면 pr이 더 적은 수로 이동함. 그리고 반복문 종료
	//              반복문 빠져나와서 pr을 반환하는 것이 중요하다.
	public static long binSearch(int n) {

		int pl = 0;
		int pr = n - 1;
		int pc;

		do {
			pc = (pl + pr) / 2;

			long sum = getSum(pc);

			if (sum == M)
				return pc;

			if (sum < M)
				pr = pc - 1;
			else
				pl = pc + 1;

		} while (pl <= pr);

		return pr;

	}

	public static long getSum(long H) {

		long sum = 0;

		for (int i = 0; i < N; i++) {
			if (H < arr[i])
				sum += (long) (arr[i] - H);
		}

		return sum;
	}
}
