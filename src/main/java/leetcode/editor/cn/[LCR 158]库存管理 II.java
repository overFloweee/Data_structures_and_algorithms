// 仓库管理员以数组 stock 形式记录商品库存表。stock[i] 表示商品 id，可能存在重复。请返回库存表中数量大于 stock.length / 2
// 的商品 id。
//
//
//
// 示例 1:
//
//
// 输入: stock = [6, 1, 3, 1, 1, 1]
// 输出: 1
//
//
//
// 限制：
//
//
// 1 <= stock.length <= 50000
// 给定数组为非空数组，且存在结果数字
//
//
//
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 409 👎 0


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{
    public int inventoryManagement1(int[] stock)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stock.length; i++)
        {
            if (map.get(stock[i]) == null)
            {
                map.put(stock[i], 0);
            }
            map.put(stock[i], map.get(stock[i]) + 1);
        }

        int max = 0;
        int value = 0;
        for (Integer i : map.keySet())
        {
            Integer cur = map.get(i);
            if (cur > max)
            {
                max = cur;
                value = i;
            }
        }

        return value;

    }

    // 数组排序法： 将数组 stock 排序，数组中点的元素 一定为众数
    public int inventoryManagement2(int[] stock)
    {
        Arrays.sort(stock);

        return stock[stock.length / 2];

    }
}
// leetcode submit region end(Prohibit modification and deletion)
