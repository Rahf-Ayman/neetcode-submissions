class Solution {
    public int orangesRotting(int[][] grid) {
        int max = 0;
        PriorityQueue<int []> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
//        int [][] weightedGrid = new int[grid.length][grid[0].length];
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 2)
                    queue.add(new int[]{i ,j,0});
            }
        }
        int dx[] = {1,-1,0,0};
        int dy[] = {0,0,1,-1};

        while(!queue.isEmpty()){
            int [] currNode = queue.poll();
            for(int z = 0;z < 4;z++){
                int x = currNode[0] + dx[z];
                int y = currNode[1] + dy[z];

                if(x >= grid.length || x < 0 || y < 0 || y >= grid[0].length) continue;
                int newweight = currNode[2] + 1;
                if(grid[x][y] != 1) continue;
                if(newweight > max)
                    max = newweight;
                queue.add(new int[]{x ,y,newweight});
                grid[x][y] = 2;
            }
        }
        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }

        return max;
    }
}
