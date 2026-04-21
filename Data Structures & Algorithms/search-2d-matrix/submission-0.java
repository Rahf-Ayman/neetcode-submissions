class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lrow = 0;
        int rrow = matrix.length - 1;
        int lcol = 0;
        int rcol = matrix[0].length - 1;

        while(lrow <= rrow){
            int midRow = lrow + (rrow - lrow) / 2;
            if(matrix[midRow][0] > target){
                rrow = midRow - 1;
            }else if(matrix[midRow][matrix[0].length - 1] < target){
                lrow = midRow + 1;
                lcol = 0;
                rcol = matrix[0].length - 1;
                
            }else{
                break;
            }
        }
        if(!(lrow <= rrow)) return false;
        
        int row = lrow + (rrow - lrow) / 2;
        while(lcol <= rcol){
            int midCol = lcol + (rcol - lcol) / 2;
            if(matrix[row][midCol] > target){
                rcol = midCol - 1;
            }else if (matrix[row][midCol] < target){
                lcol = midCol + 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
