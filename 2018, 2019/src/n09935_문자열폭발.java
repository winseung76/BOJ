import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeSet;

public class n09935_¹®ÀÚ¿­Æø¹ß {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		TreeSet sets = new TreeSet();
		int n = Integer.parseInt(br.readLine());

		String str = null;
		for (int i = 0; i < n; i++) {
			sets.add(br.readLine());
		}
		Iterator it = sets.iterator();
		while (it.hasNext()) {
			StringBuffer buf = new StringBuffer();
			buf.append(it.next());
			str = buf.reverse().toString();
			if (sets.contains(str))
				break;
		}
		int index = str.length() / 2;
		bw.write(str.length() + " " + str.charAt(index));
		bw.flush();
	}
}
