import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class n01850_최대공약수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		BigInteger tmp_A = new BigInteger(st.nextToken());
		BigInteger tmp_B = new BigInteger(st.nextToken());

		BigInteger A = tmp_A.max(tmp_B);
		BigInteger B = tmp_A.min(tmp_B);

		BigInteger r = new BigInteger("1");

		while (r.compareTo(new BigInteger("0")) > 0) {
			r = A.mod(B);
			A = B;
			B = r;
		}
		for (BigInteger i = BigInteger.ZERO; i.compareTo(A) == -1; i = i.add(BigInteger.ONE)) {
			bw.write("1");
		}
		bw.write("\n");
		bw.flush();
	}
}
