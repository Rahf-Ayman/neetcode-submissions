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

    public boolean search(String word) {
        return dfs(word ,0,root);
    }

    public boolean dfs(String word , int index ,TrieNode node){
        TrieNode curr = node;
        for(int i = index;i < word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(int j = 0;j < curr.child.length;j++){
                    if(curr.child[j] != null && dfs(word ,i + 1,curr.child[j])){
                        return true;
                    }
                    
                }
                return false;
            }else{
                int ind = c - 'a';
                if(curr.child[ind] == null){
                    curr.child[ind] = new TrieNode();
                }
                curr = curr.child[ind];
            }

        }
        return curr.isEndOfWord;
    }
}
