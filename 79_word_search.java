/* 
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 Solution:
 - Simple backtracking algorithm. We use a recursive dfs to keep track of the current subword.
 - Keep bool array to avoid using same letter twice.
 - Java sol more efficient than python
*/



class Solution {
    public int[][] cardinalDirections = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                //Start a new search at this square
    	        if(searchSquare(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchSquare(char[][]board, boolean[][]visited, int x, int y, String word, int position){
        if(position >= word.length()){
            return true;
        }

        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]){
            return false;
        }

        if(word.charAt(position) == board[x][y]){
            visited[x][y] = true;
            for(int[] directions: cardinalDirections){
                if(searchSquare(board, visited, x+directions[0], y+directions[1], word, position+1)){
                    return true;
                }
            }
            visited[x][y] = false;
        }

        return false;

    }
}