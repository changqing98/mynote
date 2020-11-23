public class WordSearch{
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] map = new boolean[row][col];
        for (int i = 0; i< row;i++){
            for(int j = 0; j < col;j++){
                if(dfs(board, 0, word, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int k, String word, int i, int j){
        if(k == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length ){
            return false;
        }
        if(board[i][j] != word.charAt(k)){
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '-';
        boolean result = dfs(board, k+1, word, i + 1, j) ||dfs(board, k+1, word, i - 1, j) || dfs(board, k+1, word, i, j+ 1) || dfs(board, k+1, word, i, j - 1);  
        board[i][j] = tmp;
        return result;
    }
}