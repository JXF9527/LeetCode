package Trie208;

public class Trie {

    private Trie[] child = new Trie[26];
    private boolean isEnd = false;

    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if(node.child[c - 'a'] == null) {
                node.child[c - 'a'] = new Trie();
            }
            node = node.child[c - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if(node.child[c - 'a'] == null) {
                return false;
            }
            node = node.child[c - 'a'];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            if(node.child[c - 'a'] == null) {
                return false;
            }
            node = node.child[c - 'a'];
        }
        return true;
    }
}
