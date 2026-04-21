class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char board [][] =new char[n][n];
        boolean col [] = new boolean[n];
        boolean [] posdia = new boolean[n * 2];
        boolean [] negdia = new boolean[n * 2];
        for(int i = 0;i < n;i++){
            for(int j= 0;j < n;j++){
                board[i][j] = '.';
            }
        }
        back(0 ,n,col,posdia,negdia,board,list);
        return list;
    }
    public void back(int r ,int n,boolean [] col, boolean[] posdia ,boolean[] negdia ,char[][] board ,List<List<String>> list ){
        if(r == n){
            List<String> copy = new ArrayList<>();
            for(char [] c : board){
                copy.add(new String(c));
            }
            list.add(copy);
            return;
        }
        for(int c = 0;c < n;c++){
            if(col[c] || posdia[r + c] || negdia[r - c + n]){
                continue;
            }

            col[c] = true;
            posdia[r + c] = true;
            negdia[r - c + n] = true;
            board[r][c] = 'Q';
            
            back(r + 1,n,col,posdia,negdia,board,list);

            col[c] = false;
            posdia[r + c] = false;
            negdia[r - c + n] = false;
            board[r][c] = '.';
        }
    }
}
