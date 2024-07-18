class Solution {


    public void solveSudoku(char[][] board) {

        backTrack(board, 0);

    }

    public void backTrack(char[][] board, int row) {
        if (row == 9) {
            return;
        }

        for (int j = 0; j < board.length; ++j) {
            if (board[row][j] != '.') {
                continue;
            }

            for (int num = 0; num <= 9; num++) {
                char temp = (char) num;
                if (!isValid(board, row, j, temp)) {
                    continue;
                }

                board[row][j] = temp;
                backTrack(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        int n = board.length;
        for (int i = 0; i < n; ++i) {
            if (board[i][col] == num) {
                return false;
            }
            if (board[row][i] == num) {
                return false;
            }
        }

        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
