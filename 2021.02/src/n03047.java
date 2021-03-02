import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class n03047 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++)
			arr[i] = Integer.parseInt(sarr[i]);

		Arrays.sort(arr);

		HashMap<Character, Integer> map = new HashMap<>();

		map.put('A', arr[0]);
		map.put('B', arr[1]);
		map.put('C', arr[2]);

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++)
			bw.write(map.get(str.charAt(i)) + " ");
		bw.flush();

	}

}
