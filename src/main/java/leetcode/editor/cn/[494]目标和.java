import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    int res = 0;

    // 回溯 - 初解
    public int findTargetSumWays1(int[] nums, int target) {
        backTracking(nums, target, 0, 0);
        return res;
    }

    public void backTracking(int[] nums, int target, int sum, int index) {
        if (sum == target && index == nums.length) {
            res++;
            return;
        }
        if (index >= nums.length) {
            return;
        }

        for (int j = -1; j <= 1; j += 2) {
            int cur = nums[index] * j;
            sum += cur;
            backTracking(nums, target, sum, index + 1);
            sum -= cur;
        }


    }

    // 动态规划 - 没解出来
    // 原因：找子数组组成总和为 x 的动态规划套路，只能找出有没有这种情况
    // 但是没想到怎么做统计
    public int findTargetSumWays2(int[] nums, int target) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int n = nums.length;
        int x = (sum + target) / 2;
        int[] dp = new int[x + 1];

        for (int i = 0; i <= x; ++i) {
            if (i >= nums[0]) {
                dp[i] = nums[0];
            }
        }

        int res = 0;
        for (int i = 1; i < n; ++i) {
            for (int j = x; j >= 0; --j) {
                if (j >= nums[i]) {
                    dp[j] = Math.max(dp[j], nums[i] + dp[j - nums[i]]);
                }
            }
            System.out.println(Arrays.toString(dp));

            if (dp[x] == target) {
                res++;
            }
        }

        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {

        // 01背包应用之“有多少种不同的填满背包最大容量的方法“
        // 易于理解的二维数组解法及详细注释

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // 注意nums[i] >= 0的题目条件，意味着sum也是所有nums[i]的绝对值之和
        // 这里保证了sum + target一定是大于等于零的，也就是left大于等于零（毕竟我们定义left大于right）
        if (sum < Math.abs(target)) {
            return 0;
        }

        // 利用二元一次方程组将left用target和sum表示出来（替换掉right组合），详见代码随想录对此题的分析
        // 如果所求的left数组和为小数，则作为整数数组的nums里的任何元素自然是没有办法凑出这个小数的
        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int left = (sum + target) / 2;

        // dp[i][j]：遍历到数组第i个数时， left为j时的能装满背包的方法总数
        int[][] dp = new int[nums.length][left + 1];

        // 初始化最上行（dp[0][j])，当nums[0] == j时（注意nums[0]和j都一定是大于等于零的，因此不需要判断等于-j时的情况），有唯一一种取法可取到j，dp[0][j]此时等于1
        // 其他情况dp[0][j] = 0
        // java整数数组默认初始值为0
        if (nums[0] <= left) {
            dp[0][nums[0]] = 1;
        }

        // 初始化最左列（dp[i][0])
        // 当从nums数组的索引0到i的部分有n个0时（n > 0)，每个0可以取+/-，因此有2的n次方中可以取到j = 0的方案
        // n = 0说明当前遍历到的数组部分没有0全为正数，因此只有一种方案可以取到j = 0（就是所有数都不取）
        int numZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numZeros++;
            }
            dp[i][0] = (int) Math.pow(2, numZeros);

        }

        // 递推公式分析：
        // 当nums[i] > j时，这时候nums[i]一定不能取，所以是dp[i - 1][j]种方案数
        // nums[i] <= j时，num[i]可取可不取，因此方案数是dp[i - 1][j] + dp[i - 1][j - nums[i]]
        // 由递推公式可知，先遍历i或j都可
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= left; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= left; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }

        return dp[nums.length - 1][left];

    }


    public int findTargetSumWays4(int[] nums, int target) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum + target) % 2 != 0) {
            return 0; // 如果总和与target的和不是偶数，则无解
        }
        int total = (sum + target) / 2; // 计算需要达到的总和

        int[] dp = new int[total + 1];
        dp[0] = 1; // 初始化dp数组，和为0的组合数为1

        for (int num : nums) {
            for (int j = total; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[total]; // 返回和为目标值的组合数
    }
}
