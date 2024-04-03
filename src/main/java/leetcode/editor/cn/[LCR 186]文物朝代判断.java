// 展览馆展出来自 13 个朝代的文物，每排展柜展出 5 个文物。某排文物的摆放情况记录于数组 places，其中 places[i] 表示处于第 i 位文物的
// 所属朝代编号。其中，编号为 0 的朝代表示未知朝代。请判断并返回这排文物的所属朝代编号是否连续（如遇未知朝代可算作连续情况）。
//
//
//
// 示例 1：
//
//
// 输入: places = [0, 6, 9, 0, 7]
// 输出: True
//
//
//
//
// 示例 2：
//
//
// 输入: places = [7, 8, 9, 10, 11]
// 输出: True
//
//
//
//
// 提示：
//
//
// places.length = 5
// 0 <= places[i] <= 13
//
//
//
//
// Related Topics 数组 排序 👍 365 👎 0


import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
class Solution
{


    public boolean checkDynasty1(int[] places)
    {
        Arrays.sort(places);

        int joker = 0;
        for (int i = 0; i < places.length - 1; i++)
        {
            int place = places[i];
            if (place == 0)
            {
                joker++;
                continue;
            }

            int place1 = places[i + 1];
            int chazhi = place1 - place;
            if (chazhi == 1)
            {
                continue;
            }

            if (chazhi - 1 > joker || chazhi == 0)
            {
                return false;

            }
            else
            {
                joker -= chazhi;

            }
        }
        return true;
    }


    public boolean checkDynasty(int[] places)
    {
        int unknown = 0;
        Arrays.sort(places); // 数组排序
        for (int i = 0; i < 4; i++)
        {
            if (places[i] == 0)
            {
                unknown++; // 统计未知朝代数量
            }
            else if (places[i] == places[i + 1])
            {
                return false; // 若有重复，提前返回 false
            }
        }
        return places[4] - places[unknown] < 5; // 最大编号朝代 - 最小编号朝代 < 5 则连续

    }
}
// leetcode submit region end(Prohibit modification and deletion)
