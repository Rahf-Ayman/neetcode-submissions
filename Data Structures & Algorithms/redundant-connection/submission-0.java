class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int parent[] = new int [edges.length + 1];
        int rank[] = new int [edges.length + 1];
        for(int i = 1;i <= edges.length;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int []i : edges){
            if(!union(parent,rank,i[0],i[1])){
                return i;
            }
        }
        return new int [0];
    }
    public boolean union(int [] parent,int [] rank,int i,int j){
        int p1 = find(parent,i);
        int p2 = find(parent,j);

        if(p1 == p2) return false; // this edge make a cycle

        if(rank[p1] > rank[p2]){ // connect small tree under large
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else{
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
    public int find(int [] parent,int i){
        if(parent[i] == i){
            return i;
        }
        return find(parent, parent[i]);
    }
}
