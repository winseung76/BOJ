import java.io.*;

public class n02666 {

	static int N;
	static boolean[] closet;
	static int[] arr;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		closet = new boolean[N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			closet[Integer.parseInt(input[i])] = true;
		}

		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		solve(0, 0);
		bw.write(min + "\n");
		bw.flush();

	}

	public static void solve(int idx, int cnt) {

		if (idx == arr.length) {
			min = Math.min(min, cnt);
			return;
		}

		int num = arr[idx];

		if (closet[num]) {
			solve(idx + 1, cnt);
		}

		else {

			int i = num - 1;
			while (i >= 1) {
				if (closet[i]) {
					for (int j = i; j < num; j++) {
						closet[j] = false;
					}
					closet[num] = true;
					cnt += num - i;

					solve(idx + 1, cnt);

					cnt -= num - i;
					for (int j = i + 1; j <= num; j++) {
						closet[j] = false;
					}
					closet[i] = true;
					break;
				}
				i--;
			}

			i = num + 1;
			while (i <= N) {
				if (closet[i]) {
					for (int j = num + 1; j <= i; j++) {
						closet[j] = false;
					}
					closet[num] = true;
					cnt += i - num;
					
					solve(idx + 1, cnt);

					cnt -= i - num;
					for (int j = num; j < i; j++) {
						closet[j] = false;
					}
					closet[i] = true;
					break;
				}
				i++;
			}

		}
	}

}
