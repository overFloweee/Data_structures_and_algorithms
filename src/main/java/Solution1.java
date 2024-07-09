import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    // 初解 - 非常困难的完成了
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int index = 0;
        Arrays.sort(nums);
        backTracking(nums, index);
        return res;
    }

    public static void main(String[] args) {
        new Solution1().subsetsWithDup(new int[]{1, 2, 2});
    }


    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void backTracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            // 这里的判断条件是 i > index，而不是 i > 0这个简单的条件
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public void backTracking2(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; ++i) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            int last = path.get(path.size() - 1);
            while (i < nums.length - 1 && last == nums[i + 1]) {
                i++;
            }
            path.remove(path.size() - 1);
        }
    }

}
// leetcode submit region end(Prohibit modification and deletion)
