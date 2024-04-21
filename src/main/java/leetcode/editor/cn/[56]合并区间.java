// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
// 回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
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
// Related Topics 数组 排序 👍 2301 👎 0


import java.util.Arrays;
import java.util.Comparator;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public int[][] merge(int[][] intervals)
    {
        int n = intervals.length;
        if (n == 1)
        {
            return intervals;
        }

        // 排序
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                int i = o1[0] - o2[0];
                if (i == 0)
                {
                    i = o1[1] - o2[1];
                }
                return i;
            }
        });


        int size = 0;
        for (int i = 1; i < n; i++)
        {
            if (intervals[i - 1][1] >= intervals[i][1])
            {
                intervals[i] = new int[]{intervals[i - 1][0], intervals[i - 1][1]};
                size++;
            }
            // 后一个集合 的首元素 > 后一个集合的 尾元素，需要合并
            else if (intervals[i - 1][1] >= intervals[i][0])
            {
                intervals[i] = new int[]{intervals[i - 1][0], intervals[i][1]};
                size++;
            }

        }

        for (int[] interval : intervals)
        {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println("size: " + size);

        int[][] res = new int[n - size][];

        System.arraycopy(intervals, size, res, 0, n - size);

        return res;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
