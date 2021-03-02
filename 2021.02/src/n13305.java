import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class n13305 {

	static int N;
	static long[] road, cost;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		road = new long[N - 1];
		cost = new long[N];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < N - 1; i++)
			road[i] = Long.parseLong(sarr[i]);

		sarr = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			cost[i] = Long.parseLong(sarr[i]);

		bw.write(solve() + "\n");
		bw.flush();

	}

	public static long solve() {

		int pos = 0;
		long sum = 0;
		long price = 0;

		for (int i = 0; i < N - 1; i++) {

			if (i > 0 && cost[pos] > cost[i]) {
				price += sum * cost[pos];
				pos = i;
				sum = 0;
			}

			sum += road[i];
		}

		price += sum * cost[pos];

		return price;

	}

}
