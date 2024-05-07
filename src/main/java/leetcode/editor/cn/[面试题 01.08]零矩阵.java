// 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
//
//
//
// 示例 1：
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
// 输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
//
//
// 示例 2：
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
// 输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
//
//
// Related Topics 数组 哈希表 矩阵 👍 173 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n - 1 && matrix[i][j] != 0) {
                j++;
            }

            if (j != n - 1) {
                // 行清零
                for (int z = 0; z < n; z++) {
                    System.out.println(z);
                    if (z > j && matrix[z][j] != 0) {
                        matrix[z][j] = 2;
                    }
                    else {
                        matrix[i][z] = 0;
                    }
                }
                // 列清零
                for (int z = 0; z < m; z++) {
                    if (z > i) {
                        matrix[z][j] = 2;
                    }
                    else {
                        matrix[z][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 创建了一个新数组，保存清零的状态
    public void setZeroes2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(newArr[i], 1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Arrays.fill(newArr[i], 0);
                    for (int z = 0; z < m; z++) {
                        newArr[z][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (newArr[i][j] == 0) {
                    matrix[i][j] = newArr[i][j];
                }
            }
        }
    }


    // 官解：对上述进行优化
    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }


    // 别人的解，和自己的解 时间复杂度想通
    public void setZeroes(int[][] matrix) {
        List<int[]> zero = new ArrayList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zero.add(new int[]{i, j}); // 记录矩阵中是0的坐标
                }
            }
        }
        // 逐行逐列清零
        for (int i = 0; i < zero.size(); i++) {
            int row = zero.get(i)[0];
            int col = zero.get(i)[1];
            for (int a = 0; a < matrix.length; a++) {
                matrix[a][col] = 0; // 列清零
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0; // 行清零
            }
        }
    }
}
// leetcode submit region end(Prohibit modification and deletion)
