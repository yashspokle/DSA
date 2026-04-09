class WordDictionary {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean end;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    } 
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.next[i] == null) node.next[i] = new TrieNode();
            node = node.next[i];
        }
        node.end = true;
    }  
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    boolean dfs(String word, int idx, TrieNode node) {
        if (node == null) return false;
        if (idx == word.length()) return node.end;
        char c = word.charAt(idx);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (dfs(word, idx + 1, node.next[i])) return true;
            }
            return false;
        }
        return dfs(word, idx + 1, node.next[c - 'a']);
    }
}