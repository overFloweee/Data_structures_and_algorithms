import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author qifei
 * @since 2024-04-11
 */
public class Main
{
    public static void main(String[] args)
    {
        String[] location = new String[]{"漠河", "沈阳", "北京", "广州", "昆明"};

        HashMap<String, Integer> map = new HashMap<>(5);
        // KEY - 气象观测站
        // VALUE - 30天内降雨数组，如果无降雨则为 0，若有降水，则记录实际降水量
        map.put("漠河", -1);
        map.put("沈阳", -1);
        map.put("北京", -1);
        map.put("广州", -1);
        map.put("昆明", -1);

        // 此处为 每个气象观测站的 降雨输入用例
        ArrayList<Integer> nums = new ArrayList<>(30);
        // 5个气象观测站 降雨量 的集合
        List<List<Integer>> list = new ArrayList<>(5);
        for (int i = 0; i < 5; i++)
        {
            list.add(nums);
        }

        // 依次获取每个气象观测站的 最大连续无降雨天数
        for (int i = 0; i < 5; i++)
        {
            int max = getMax(nums);
            map.put(location[i], max);
        }
    }


    public static int getMax(List<Integer> nums)
    {
        int max = Integer.MIN_VALUE;
        int size = 0;
        for (int num : nums)
        {
            if (num == 0)
            {
                size++;
            }
            else
            {
                max = Math.max(size, max);
                size = 0;
            }

        }

        return Math.max(size, max);

    }
}
