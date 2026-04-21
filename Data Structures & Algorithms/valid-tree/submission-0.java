class Solution {
    public static boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false;
        Map<Integer,List<Integer>> adj = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n ;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int [] i : edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        
        dfs(adj,set,0); // check connected
        return set.size() == n;
    }
    public static void dfs(Map<Integer,List<Integer>> adj ,HashSet<Integer> set ,int i){
        if(set.contains(i)) return;
        set.add(i);
        for(int node : adj.get(i)){
            dfs(adj,set,node);
        }
    }
}
