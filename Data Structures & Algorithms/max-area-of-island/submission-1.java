class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int c = 0;
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    int area = DFS(grid,i,j);
                    if(area > c){
                        c = area;
                    }
                }
            }
        }
        return c;
    }

    public int DFS(int[][] grid, int i ,int j){
        int dx[] = {0 ,1 , 0, -1};  // up right down left
        int dy[] = {1 ,0 ,-1 , 0};
        
        int res = 1;
        for(int k = 0;k < 4;k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0) continue;
            if(grid[x][y] == 1){
                grid[x][y] = 0;
                res += DFS(grid,x,y);
            }
        }
        return res;
    }
}
