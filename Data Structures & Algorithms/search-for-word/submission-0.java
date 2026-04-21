class Solution {
    public boolean exist(char[][] board, String word) {
        boolean [][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < board[0].length;j++){
                if(DFS(visited,word,i,j,0,board)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean DFS(boolean [][]visited ,String word ,int row ,int col ,int i ,char [][]board){
        if(i >= word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(i)){
            return false;
        }
        if(visited[row][col]){
            return false;
        }

        visited[row][col] = true;

        boolean res = DFS(visited ,word,row - 1, col,i + 1,board) ||
                DFS(visited ,word,row, col - 1,i + 1,board) ||
                DFS(visited ,word,row , col + 1,i + 1,board) ||
                DFS(visited ,word,row + 1, col,i + 1,board);

        visited[row][col] = false;

        return res;

    }
}
