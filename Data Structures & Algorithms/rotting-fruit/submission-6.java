class Solution {
    public int orangesRotting(int[][] grid) {
        int max = 0;
        int fruit = 0;
        Queue<int []> queue = new ArrayDeque<>();
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i ,j});
                if(grid[i][j] == 1)
                    fruit++;
            }
        }
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        while(fruit > 0&&!queue.isEmpty()){
            int len = queue.size();
            for(int m = 0;m < len ;m++){
                int [] currNode = queue.poll();
                for(int z = 0;z < 4;z++){
                    int x = currNode[0] + dx[z];
                    int y = currNode[1] + dy[z];

                    if(x >= grid.length || x < 0 || y < 0 || y >= grid[0].length) continue;
                    if(grid[x][y] != 1) continue;
                    queue.add(new int[]{x ,y});
                    grid[x][y] = 2;
                    fruit--;
                }
            }
            max++;
        }

        return fruit == 0? max : -1;
    }
}
