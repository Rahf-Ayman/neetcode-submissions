class TrieNode{
    TrieNode [] childern = new TrieNode[26];
    boolean isEndOfWord = false;
}
class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                curr.childern[index] = new TrieNode();
            }
            curr = curr.childern[index]; 
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                return false;
            }
            
            curr = curr.childern[index];  
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            int index = c -'a';
            if(curr.childern[index] == null){
                return false;
            }
            
            curr = curr.childern[index]; 
        }

        return true;
    }
}
