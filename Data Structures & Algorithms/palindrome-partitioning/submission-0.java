class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(new ArrayList<>(),list,s,0,0);
        return list;
    }
    public static void dfs(List<String> sublist ,List<List<String>> list,String s ,int j ,int i){
        if(i >= s.length()){
            if(i == j){
                list.add(new ArrayList<>(sublist));
            }
            return;
        }
        if(palind(s,j,i)){
            sublist.add(s.substring(j,i + 1));
            dfs(sublist,list,s,i + 1,i + 1);
            sublist.remove(sublist.size() - 1);
        }
        dfs(sublist,list,s,j,i + 1);
    }
    public static boolean palind(String s, int l ,int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
