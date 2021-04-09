package 回溯;

/**
 * @create 2019-11-15  22:27
 */
public class three_seven_数独 {

    public static void main(String[] args) {

        char[][] borad = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(borad);

        for (int i = 0; i < borad.length; i++) {
            for (int j = 0; j < borad[i].length; j++) {
                System.out.print(borad[i][j]);
            }
            System.out.println();
        }

    }


    public static void solveSudoku(char[][] board) {

        solor(board, 0, 0);

    }

    public static Boolean solor(char[][] board, int x, int y) {

        if (y == 9) {
            x++;
            y = 0;
        }
        if (x == 9) {
            return true;
        }

        if (board[x][y] != '.') {
            return solor(board, x, y + 1);

        } else {
            for (int i = 0; i < 9; i++) {
                if (test(board, x, y, (char) ((i + 1) + '0'))) {
                    board[x][y] = (char) ((i + 1) + '0');
                    if (solor(board, x, y + 1)) {
                        return true;
                    }
                    board[x][y] = '.';
                }
            }
        }

        return false;


    }

    public static Boolean test(char[][] board, int row, int col, char sum) {
        //判断行可以插不
        for (int i = 0; i < board[0].length; i++) {
            if (sum == board[row][i]) {
                return false;
            }
        }
        //判断lie可以插不
        for (int i = 0; i < board.length; i++) {
            if (sum == board[i][col]) {
                return false;
            }
        }
        //判断九宫格
        int startRow = row / 3;
        int startCol = col / 3;
        //DIYIGE
        for (int i = startRow * 3; i < startRow * 3 + 3; i++) {
            for (int j = startCol * 3; j < startCol * 3 + 3; j++) {
                if (board[i][j] == sum) {
                    return false;
                }
            }
        }
        return true;
    }
}
