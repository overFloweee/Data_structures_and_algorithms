package practice;

import java.util.HashMap;

public class LCR158_多数元素
{
    public static void main(String[] args)
    {
        int[] stock = new int[]{6,1,3,1,1,1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stock.length / 2 + 1; i++)
        {
            map.putIfAbsent(stock[i], 0);
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
                value = cur;
            }
        }
    }
}
