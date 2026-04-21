class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[][] reachablePacific = new boolean[heights.length][heights[0].length];
        boolean[][] reachableAtlantic = new boolean[heights.length][heights[0].length];

        for(int i =0;i < heights.length;i++){
            for(int j = 0;j < heights[0].length;j++){
                if(i == 0 || j == 0 ){
                    if(!reachablePacific[i][j]){
                        reachablePacific[i][j] = true;
                        DFS(heights,reachablePacific,i , j);
                    }

                }
                if(i == heights.length - 1 || j == heights[0].length - 1){
                    if(!reachableAtlantic[i][j]){
                        reachableAtlantic[i][j] = true;
                        DFS(heights,reachableAtlantic,i , j);
                    }

                }
            }
        }

        for(int i = 0;i < heights.length;i++){
            for(int j = 0;j < heights[0].length;j++){
                if(reachableAtlantic[i][j] && reachablePacific[i][j]){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(j);
                    list.add(arr);
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
