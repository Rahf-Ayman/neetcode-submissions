public class Solution {
    // Map each course to its prerequisites
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] i : prerequisites){
            adj.get(i[0]).add(i[1]);
        }
        for(int i = 0;i < numCourses;i++){
            if(!DFS(adj,set,i)){
                return false;
            }
        }
        
        return true;
    }
    public boolean DFS(List<List<Integer>> adj ,HashSet<Integer> set ,int i){
        if(set.contains(i)) return false;
        set.add(i);
        for(int node : adj.get(i)){
            if(!DFS(adj,set,node)){
                return false;
            }
        }
        set.remove(i);
        return true;
    }
}