// 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2]
//
//
// 示例 2：
//
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[9,4]
// 解释：[4,9] 也是可通过的
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 908 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 初解 错误
    public int[] intersection1(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> list = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int min = Math.min(len1, len2);

        for (int i = 0; i < min; i++) {
            set.add(nums1[i]);
            boolean addSuccess = set.add(nums2[i]);
            if (!addSuccess) {
                list.add(nums2[i]);
            }
        }

        int cha = len1 - len2;
        if (len1 <= len2) {
            nums1 = nums2;
            cha = -1 * cha;
        }

        for (int i = cha; i < len1; i++) {
            boolean addSuccess = set.add(nums1[i]);
            if (!addSuccess) {
                list.add(nums1[i]);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 初解
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums2) {
            boolean isContain = set1.contains(i);
            if (isContain) {
                set.add(i);
            }
        }

        int[] arr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            arr[index++] = num;
        }
        return arr;
    }

    // 二刷
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set = new HashSet<>();


        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                set.add(i);
            }
        }

        int[] arr = new int[set.size()];
        int index = 0;
        for (int i : set) {
            arr[index++] = i;
        }

        return arr;
    }

    // 优解
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash1 = new int[1002];
        int[] hash2 = new int[1002];
        for (int i : nums1)
            hash1[i]++;
        for (int i : nums2)
            hash2[i]++;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < 1002; i++)
            if (hash1[i] > 0 && hash2[i] > 0) {
                resList.add(i);
            }
        int index = 0;
        int res[] = new int[resList.size()];
        for (int i : resList)
            res[index++] = i;
        return res;
    }

}
// leetcode submit region end(Prohibit modification and deletion)
