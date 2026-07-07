class TrieNode{
    TrieNode[] child = new TrieNode[26];
    boolean isEndOfWord = false;
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(curr.child[index] == null){
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
        }

        curr.isEndOfWord = true;
    }

    

    
}

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        WordDictionary trie = new WordDictionary();

        for(String word : dictionary){
            trie.addWord(word);
        }
        int [] dp = new int [s.length() + 1];

        Arrays.fill(dp , -1);
        return dfs(0,s,trie,dp);
    }

    public int dfs(int i , String s, WordDictionary trie , int [] dp){
        if(i == s.length()) return 0;

        if(dp[i] != -1) return dp[i];

        int res = 1 + dfs(i + 1, s ,trie ,dp); // skip curr index and trie another substring start
        TrieNode curr = trie.root;
        for(int j = i;j < s.length();j++){
            int index = s.charAt(j) - 'a';

            if(curr.child[index] == null) break;
            curr = curr.child[index];

            if(curr.isEndOfWord){
                res = Math.min(res ,dfs(j + 1,s,trie,dp )); // min between if ignore one char and start another chunk or not ignore and start next string
            }
        }

        dp[i] = res;
        return res;

    }
}