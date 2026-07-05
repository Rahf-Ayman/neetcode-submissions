class TrieNode{
    HashMap<Character,TrieNode> child = new HashMap<>();
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
            if(curr.child.putIfAbsent(c,null) == null){
                curr.child.put(c , new TrieNode());
            }
            curr = curr.child.get(c);
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){
            if(curr.child.putIfAbsent(c,null) == null){
                return false;
            }

            curr = curr.child.get(c);
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){
            if(curr.child.putIfAbsent(c,null) == null){
                return false;
            }

            curr = curr.child.get(c);
        }

        return true;
    }
}