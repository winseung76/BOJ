import java.io.*;
import java.util.*;

public class n05052 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			List<String> list = new ArrayList<>();

			for (int j = 0; j < n; j++) {
				String str = br.readLine();
				list.add(str);
				trie.insert(str);
			}

			boolean flag = true;
			for (int j = 0; j < list.size(); j++) {
				if (!trie.checkConsist(list.get(j))) {
					flag = false;
					break;
				}
			}

			if (flag)
				bw.write("YES\n");
			else
				bw.write("NO\n");
		}

		bw.flush();

	}

	static class Trie {

		TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		public void insert(String word) {

			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), key -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}

		public boolean contain(String word) {

			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().get(word.charAt(i));

				if (thisNode == null)
					return false;
			}

			return thisNode.isLastChar();
		}

		public boolean delete(String word) {

			return delete(rootNode, word, 0);
		}

		public boolean delete(TrieNode thisNode, String word, int index) {

			char ch = word.charAt(index++);
			TrieNode childNode = thisNode.getChildNodes().get(ch);

			if (index == word.length()) {

				if (!childNode.isLastChar())
					return false;

				childNode.setIsLastChar(false);

				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);

				return true;
			}

			if (delete(childNode, word, index)) {
				if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					childNode.getChildNodes().remove(ch);

				return true;
			}
			return false;

		}

		public boolean checkConsist(String word) {

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().get(word.charAt(i));

				if (i < word.length() - 1 && thisNode.isLastChar())
					return false;
			}
			return true;
		}

	}

	static class TrieNode {

		private Map<Character, TrieNode> childNodes = new HashMap<>();
		private boolean isLastChar;

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

		public boolean isLastChar() {
			return isLastChar;
		}
	}
}
