class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] reachablePacific = new boolean[heights.length][heights[0].length];
        boolean[][] reachableAtlantic = new boolean[heights.length][heights[0].length];
        for(int i = 0;i < heights.length;i++){
            DFS(heights,reachablePacific,i , 0);
            DFS(heights,reachableAtlantic, i,heights[0].length - 1);
        }
        for(int i = 0;i < heights[0].length;i++){
            DFS(heights,reachablePacific,0 , i);
            DFS(heights,reachableAtlantic,heights.length - 1 ,i);
        }

        for(int i = 0;i < heights.length;i++){
            for(int j = 0;j < heights[0].length;j++){
                if(reachableAtlantic[i][j] && reachablePacific[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
     }
    public void DFS(int[][] heights, boolean[][] reachable ,int i ,int j){
        int dx [] = {1,-1,0,0};
        int dy [] = {0,0,1,-1};
        reachable[i][j] = true;

        for(int k = 0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];

            if(x >= heights.length || x < 0 || y >= heights[0].length || y < 0) continue;
            if (reachable[x][y]) continue;
            if(heights[x][y] >= heights[i][j]){
                DFS(heights,reachable,x,y);
            }
        }
    }
}
