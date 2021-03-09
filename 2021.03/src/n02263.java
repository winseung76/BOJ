import java.io.*;

public class n02263 {

	static int n;
	static int[] in, post, pre;
	static int idx;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		in = new int[n];
		post = new int[n];
		pre = new int[n];

		String[] sarr = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			in[i] = Integer.parseInt(sarr[i]);

		sarr = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			post[i] = Integer.parseInt(sarr[i]);

		getPreOrder(0, n - 1, 0, n - 1);

		for (int n : pre)
			bw.write(n + " ");

		bw.flush();

	}

	public static void getPreOrder(int is, int ie, int ps, int pe) {

		// is�� �ο��� ������ ���� ��ġ, ie�� �ο����� �� ��ġ
		// ps�� ����Ʈ���� ������ ���� ��ġ, pe�� ����ġ

		if (is <= ie && ps <= pe) {

			pre[idx++] = post[pe]; // ����Ʈ ������ ���� ��������(post[pe]) ��Ʈ ����̴�.

			int pos = is;
			for (int i = is; i <= ie; i++) { // �ο������� ��Ʈ ����� ��ġ�� ã��
				if (in[i] == post[pe]) {
					pos = i;
					break;
				}
			}

			// ���� �ڽ� Ʈ���� ������ �ٽ� �Ȱ��� ������ �ݺ��Ѵ�.
			getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
			// ������ �ڽ� Ʈ���� ������ �ٽ� �Ȱ��� ������ �ݺ��Ѵ�.
			getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
		}
	}
}
