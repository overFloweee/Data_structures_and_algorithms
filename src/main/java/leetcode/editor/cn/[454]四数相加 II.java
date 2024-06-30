// 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
//
// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
//
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
// 输出：2
// 解释：
// 两个元组如下：
// 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
// 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
//
//
// 示例 2：
//
//
// 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
// 输出：1
//
//
//
//
// 提示：
//
//
// n == nums1.length
// n == nums2.length
// n == nums3.length
// n == nums4.length
// 1 <= n <= 200
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸
//
//
// Related Topics 数组 哈希表 👍 1011 👎 0


import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 执行耗时:197 ms,击败了5.18% 的Java用户
    // 内存消耗:44.2 MB,击败了5.58% 的Java用户
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = getMap(nums1, nums2);
        Map<Integer, Integer> map2 = getMap(nums3, nums4);
        int num = 0;
        for (int i : map1.keySet()) {
            if (map2.containsKey(-i)) {
                num += map1.get(i) * map2.get(-i);
            }
        }

        return num;
    }

    public static Map<Integer, Integer> getMap(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(n1 * n2);

        for (int i : nums1) {
            for (int j : nums2) {
                int num = i + j;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return map;
    }

    // 优化
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                int num = i + j;
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int ans = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                ans += map.getOrDefault(0 - u - v, 0);
            }
        }
        return ans;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
