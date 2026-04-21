class Solution {
     public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int cost = 0;
        int num = 0;
        int V = points.length;
        for(int i = 0;i < points.length;i++){
            for(int j = i + 1;j < points.length;j++){
                int wei = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int []{i ,j ,wei});
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[2]));
        int [] parent = new int [V]; //DSU
        int [] rank = new int [V];
        for(int i = 0;i < V;i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int [] edge : edges){
            if(union(parent,rank,edge[0],edge[1])){
                cost += edge[2];
                if(++num == V - 1) return cost;
            }
        }
        return cost;
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
