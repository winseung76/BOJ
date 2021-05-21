import java.io.*;
import java.util.*;

public class n16934 {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		Trie trie = new Trie();
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {

			String word = br.readLine();

			if (trie.contain(word)) {
				map.put(word, map.get(word) + 1);
				bw.write(word + map.get(word) + "\n");
			} else {
				int idx = trie.getIdx(word);
				bw.write(word.substring(0, idx + 1) + "\n");

				trie.insert(word);
				map.put(word, 1);
			}
		}

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

		public int getIdx(String word) {

			if (word.length() == 1)
				return word.length() - 1;

			TrieNode thisNode = rootNode;

			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);

				if (!thisNode.getChildNodes().containsKey(ch))
					return i;

				thisNode = thisNode.getChildNodes().get(ch);
			}

			return word.length() - 1;
		}

		public boolean contain(String word) {

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

			return delete(rootNode, word, 0);
		}

		public boolean delete(TrieNode thisNode, String word, int idx) {

			char ch = word.charAt(idx++);
			TrieNode childNode = thisNode.getChildNodes().get(ch);

			if (idx == word.length()) {

				if (!childNode.isLastChar())
					return false;

				if (childNode.getChildNodes().isEmpty()) {
					thisNode.getChildNodes().remove(ch);
					return true;
				}

				return false;
			}

			if (delete(childNode, word, idx)) {

				if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
					thisNode.getChildNodes().remove(ch);
					return true;
				}

				return false;
			}

			return false;
		}
	}

}
