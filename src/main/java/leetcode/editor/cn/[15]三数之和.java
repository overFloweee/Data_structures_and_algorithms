// 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
// k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
// 你返回所有和为 0 且不重复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
// 解释：
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
// 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
// 注意，输出的顺序和三元组的顺序并不重要。
//
//
// 示例 2：
//
//
// 输入：nums = [0,1,1]
// 输出：[]
// 解释：唯一可能的三元组和不为 0 。
//
//
// 示例 3：
//
//
// 输入：nums = [0,0,0]
// 输出：[[0,0,0]]
// 解释：唯一可能的三元组和为 0 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 3000
// -10⁵ <= nums[i] <= 10⁵
//
//
// Related Topics 数组 双指针 排序 👍 6899 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解 没解出来
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);


        int n = nums.length;
        for (int i = 0; i < 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                List<Integer> tmpList = new ArrayList<>();
                int num = nums[i] + nums[j];
                if (map.containsKey(0 - num) && map.get(0 - num) != i && map.get(0 - num) != j) {
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(0 - num);
                }
                else {
                    map.put(nums[j], j);
                }
                if (!tmpList.isEmpty()) {
                    list.add(tmpList);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        for (int i = 0; i < n - 2; i++) {
            // 排序之后如果第一个元素已经大于零
            // 那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return list;
            }

            // 对a去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            l = i + 1;
            r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) {
                    r--;
                }
                else if (sum < 0) {
                    l++;
                }
                else {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // 对b、c的运动轨迹去重
                    while (r > l && nums[r] == nums[r - 1]) r--;
                    while (r > l && nums[l] == nums[l + 1]) l++;
                    l++;
                    r--;
                }
            }
        }
        return list;
    }
}
// leetcode submit region end(Prohibit modification and deletion)
