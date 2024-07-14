import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] used;

    public List<List<String>> solveNQueens(int n) {
        used = new char[n][n];
        for (char[] chars : used) {
            Arrays.fill(chars, '.');
        }
        backTracking(n, 0);
        return res;
    }

    public void backTracking(int n, int rowIndex) {
        if (rowIndex == n) {
            res.add(arrayToList(used));
        }

        for (int j = 0; j < n; ++j) {
            if (!isValid(n, rowIndex, j)) {
                continue;
            }

            used[rowIndex][j] = 'Q';
            backTracking(n, rowIndex + 1);
            used[rowIndex][j] = '.';

        }

    }

    public List<String> arrayToList(char[][] used) {
        List<String> list = new ArrayList<>();
        for (char[] chars : used) {
            list.add(new String(chars));
        }
        return list;

    }

    // 当前位置是否合法，只需检查 索引位置的上半部分
    public boolean isValid(int n, int rowIndex, int colIndex) {

        // 检查列
        for (int i = 0; i < rowIndex; ++i) { // 相当于剪枝
            if (used[i][colIndex] == 'Q') {
                return false;
            }
        }

        // 无需检查行

        // 检查45度对角线
        for (int i = rowIndex - 1, j = colIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (used[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i = rowIndex - 1, j = colIndex + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (used[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }
}
