// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
// 回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
//
//
//
//
// 注意：本题与主站 56 题相同： https://leetcode-cn.com/problems/merge-intervals/
//
// Related Topics 数组 排序 👍 67 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 数组实现
    public int[][] merge1(int[][] intervals) {


        int n = intervals.length;
        int[][] newArr = new int[n][2];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int size = 0;
        for (int i = 0; i < n; ++i) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (i == 0 || newArr[size - 1][1] < l) {
                newArr[size++] = new int[]{l, r};
            }
            else {
                newArr[size - 1][1] = Integer.max(newArr[size - 1][1], r);
            }

        }

        int[][] arr = new int[size][2];
        System.arraycopy(newArr, 0, arr, 0, size);

        return arr;

    }

    // 集合实现
    public int[][] merge(int[][] intervals) {


        int n = intervals.length;
        ArrayList<int[]> newArr = new ArrayList<>(n);

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < n; ++i) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            if (i == 0 || newArr.get(newArr.size() - 1)[1] < l) {
                newArr.add(new int[]{l, r});
            }
            else {
                newArr.get(newArr.size() - 1)[1] = Integer.max(newArr.get(newArr.size() - 1)[1], r);
            }
        }


        return newArr.toArray(new int[newArr.size()][]);

    }
}
// leetcode submit region end(Prohibit modification and deletion)
