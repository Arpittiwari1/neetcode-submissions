class Solution {
    public boolean isValidSudoku(char[][] board) {
       for(int i=0;i<9;i++){
        boolean[] seen = new boolean[9];
        for(int j=0;j<9;j++){
           if(board[i][j] != '.'){
            int num = board[i][j] - '1';
            if(seen[num]) return false;
            seen[num] = true;
           }
        }
       } 
       for(int j=0;j<9;j++){
        boolean[] seen = new boolean[9];
        for(int i=0;i<9;i++){
            if(board[i][j] != '.'){
                int num = board[i][j] -'1';
                if(seen[num]) return false;
                seen[num] = true;
            }
        }
       }
       for(int rows =0;rows<3;rows++){
        for(int cols =0;cols<3;cols++){
            boolean[] seen = new boolean[9];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    char c = board[rows*3+i][cols*3+j];
                    if(c!='.'){
                        int num = c - '1';
                        if(seen[num]) return false;
                        seen[num]= true;
                    }
                }
            }
        }
       }
       return true;
    }
}
