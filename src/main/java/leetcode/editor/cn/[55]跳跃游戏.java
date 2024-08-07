public class Solution {

    // 初解 - 回溯超时

    public boolean canJump1(int[] nums) {

        return backTrack(nums, 0);
    }

    public boolean backTrack(int[] nums, int index) {

        if (index >= nums.length) {
            return true;
        }


        for (int i = 1; i <= nums[index]; ++i) {
            // index是当前的位置
            // index + i是马上要跳跃到的位置
            if (backTrack(nums, index + i)) {
                return true;
            }
            else {
                return false;
            }
        }

        return false;
    }

    // ai解
    public boolean canJump2(int[] nums) {
        // 初始化最远能到达的位置
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前位置在最远能到达的范围内
            if (i <= furthest) {
                // 更新最远能到达的位置
                furthest = Math.max(furthest, i + nums[i]);
                // 如果最远能到达的位置已经超过或等于最后一个位置，提前返回true
                if (furthest >= nums.length - 1) {
                    return true;
                }
            }
            else {
                // 当前位置无法到达，提前返回false
                return false;
            }
        }
        // 最后一个位置无法到达
        return false;
    }

    // 优解
    public boolean canJump3(int[] nums) {

        int jump = 0;
        for (int i = 0; i <= jump; ++i) {
            jump = Integer.max(jump, i + nums[i]);
            if (jump >= nums.length - 1) {
                return true;
            }

        }

        return false;
    }


    // 二刷下，提示了才解出来的
    public boolean canJump4(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int total = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            total = Math.max(i + nums[i], total);
            if (i + 1 > total) {
                return false;
            }

            if (total >= nums.length - 1) {
                return true;
            }
        }
        return false;

    }


    // 三刷
    public boolean canJump(int[] nums) {

        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max + 1 >= nums.length) {
                return true;
            }
        }
        return false;
    }


}
