import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class n01946_신입사원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		Pair[] pair;
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			pair = new Pair[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				pair[j] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(pair); // 오름차순 정렬
			int max = pair[0].b;
			int n = N;
			for (int j = 1; j < N; j++) {
				if (pair[j].b > max)
					n--;
				else if (pair[j].b < max)
					max = pair[j].b;
			}
			bw.write(n + "\n");
		}
		bw.flush();
	}

	static class Pair implements Comparable {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Object o) {
			return a - ((Pair) o).a;
		}
	}
}
