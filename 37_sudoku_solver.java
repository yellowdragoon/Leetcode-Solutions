class Solution {
    public void solveSudoku(char[][] board) {
        fillGrid(board, 0, 0);
    }
    public boolean isViablePlacement(char[][] board, int x, int y, char val){
        for(int i = 0; i<9; i++){ //row
            if(board[x][i] == val){
                return false;
            }
        }

        for(int j = 0; j<9; j++){ //col
            if(board[j][y] == val){
                return false;
            }
        }
        int boxRow = 3 * (x/3);
        int boxCol = 3 * (y/3);

        for(int i = 0; i<3; i++){ //box
            for(int j = 0; j<3; j++){
                if(board[boxRow+j][boxCol+i] == val){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean fillGrid(char[][] board, int x, int y) {
        //System.out.printf("%d, %d\n", x, y);
        int x_, y_;
        if(x == 9 && y == 0){
            return true;
        }

        if(y == 8){
            y_ = 0;
            x_ = x + 1;
        }
        else{
            y_ = y + 1;
            x_ = x;
        }

        if(board[x][y] != '.'){
            if(fillGrid(board, x_, y_)){
                return true;
            }
            return false;
        }

        for(int i = 1; i<10; i++){
            if(isViablePlacement(board, x, y, (char)(i+'0'))){
                board[x][y] = (char)(i+'0');
                if(fillGrid(board, x_, y_)){
                    return true;
                }
                board[x][y] = '.';
            }
        }
        return false;
    }
}