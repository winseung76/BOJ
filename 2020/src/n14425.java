import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class n14425 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);

		Tri tri = new Tri();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			tri.insert(str);
		}
		int cnt = 0;

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (tri.contain(str))
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

	static class TriNode {

		private Map<Character, TriNode> childNodes = new HashMap<>();
		private boolean isLastChar;

		public Map<Character, TriNode> getChildNodes() {
			return childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}

	static class Tri {

		private TriNode root;

		Tri() {
			root = new TriNode();
		}

		public void insert(String word) {

			TriNode node = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!node.getChildNodes().containsKey(c))
					node.getChildNodes().put(c, new TriNode());
				
				node = node.getChildNodes().get(c);
			}
			node.setIsLastChar(true);
		}

		public boolean contain(String word) {

			TriNode node = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				node = node.getChildNodes().get(c);

				if (node == null)
					return false;
			}

			return node.isLastChar();

		}

		public boolean delete(TriNode node, String word, int index) {

			char c = word.charAt(index);

			if (!node.getChildNodes().containsKey(c))
				return false;

			TriNode childNode = node.getChildNodes().get(c);
			index++;

			if (index == word.length()) {
				if (!childNode.isLastChar())
					return false;

				if (childNode.getChildNodes().isEmpty())
					node.getChildNodes().remove(c);
			} else
				delete(childNode, word, index);

			if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
				node.getChildNodes().remove(c);

			return true;
		}
	}

}
