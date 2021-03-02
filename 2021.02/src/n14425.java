import java.io.*;
import java.util.*;

public class n14425 {

	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			trie.insert(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (trie.contain(br.readLine()))
				cnt++;
		}
		bw.write(cnt + "\n");
		bw.flush();

	}

	static class Trie {

		private TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		// �ܾ� ����
		public void insert(String word) {

			TrieNode node = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				node = node.getChildNodes().computeIfAbsent(word.charAt(i), key -> new TrieNode());
			}
			node.setIsLastChar(true);
		}

		// �ܾ� ���� ���� Ȯ��
		public boolean contain(String word) {

			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().get(word.charAt(i));

				if (thisNode == null)
					return false;
			}
			
			return thisNode.isLastChar;
		}

		// �ܾ� ����
		public boolean delete(String word) {

			return delete(rootNode, word, 0);
		}

		public boolean delete(TrieNode thisNode, String word, int index) {

			char ch = word.charAt(index++);
			TrieNode childNode = thisNode.getChildNodes().get(ch);

			// �ܾ��� ������ ���ڸ� üũ�ϴ� ��� : base case
			if (index == word.length()) {

				// ã������ �ܾ ���� ���
				// ���簡 ������ �����ε� isLastChar�� false��°� ã�� �ܾ ���ٴ� ��
				if (!childNode.isLastChar())
					return false;

				childNode.setIsLastChar(false);

				// ���� �ܾ �������� ���
				if (childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);
				
				return true;
			}

			// ����Լ� ȣ��
			if (delete(childNode, word, index)) {

				if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty())
					thisNode.getChildNodes().remove(ch);

				return true;
			}
			return false;
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
