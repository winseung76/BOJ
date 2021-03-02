import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n10814_나이순정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int size = Integer.parseInt(br.readLine());
		MemberInfo[] infos = new MemberInfo[size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			infos[i] = new MemberInfo(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		Arrays.sort(infos);
		for (int i = 0; i < infos.length; i++) {
			bw.write(infos[i] + "\n");
			bw.flush();
		}

	}

	static class MemberInfo implements Comparable {

		private int age;
		private String name;
		private int count;

		MemberInfo(int age, String name, int count) {
			this.age = age;
			this.name = name;
			this.count = count;
		}

		public String toString() {
			return age + " " + name;
		}

		@Override
		public int compareTo(Object o) {

			if (this.age < ((MemberInfo) o).age)
				return -1;
			else if (this.age == ((MemberInfo) o).age) {
				if (this.count < ((MemberInfo) o).count)
					return -1;
				else if (this.count == ((MemberInfo) o).count)
					return 0;
				else
					return 1;
			} else
				return 1;
		}

	}
}
