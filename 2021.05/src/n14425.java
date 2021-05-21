import java.io.*;
import java.util.*;

public class n14425 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			trie.insert(str);
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (trie.contains(str))
				cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();

	}

	static class TrieNode {

		Map<Character, TrieNode> childNodes = new HashMap<>();
		boolean isLastChar;

		public void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

	}

	static class Trie {

		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word) {

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				thisNode = thisNode.getChildNodes().computeIfAbsent(ch, key -> new TrieNode());
			}

			thisNode.setIsLastChar(true);
		}

		public boolean contains(String word) {

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);

				thisNode = thisNode.getChildNodes().get(ch);

				if (thisNode == null)
					return false;
			}

			return thisNode.isLastChar();
		}

		public boolean delete(String word) {

			TrieNode thisNode = rootNode;

			return delete(word, 0, thisNode);
		}

		public boolean delete(String word, int idx, TrieNode thisNode) {

			char ch = word.charAt(idx++);
			TrieNode childNode = thisNode.getChildNodes().get(ch);

			if (idx == word.length()) {

				if (!childNode.isLastChar())
					return false;

				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);

				return true;
			}

			if (delete(word, idx, childNode)) {

				if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);

				return true;
			}

			return false;

		}
	}
}
