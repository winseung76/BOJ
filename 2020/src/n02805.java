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
	// pl = pr �� ��, sum > M �̸� ���ٸ� ��������("���" M���� ũ��)
	//              sum < M �̸� pr�� �� ���� ���� �̵���. �׸��� �ݺ��� ����
	//              �ݺ��� �������ͼ� pr�� ��ȯ�ϴ� ���� �߿��ϴ�.
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
