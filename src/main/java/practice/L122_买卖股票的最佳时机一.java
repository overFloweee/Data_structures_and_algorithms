package practice;

/**
 * @author qifei
 * @since 2024-04-02
 */
public class L122_买卖股票的最佳时机一
{
    public static void main(String[] args)
    {
        int[] a = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new L122_买卖股票的最佳时机一().maxProfit(a));
    }

    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++)
        {
            if (min > prices[i])
            {
                min = prices[i];
            }
            else
            {
                int temp = prices[i] - min;
                if (temp > max)
                {
                    max = temp;
                }
            }


        }

        return max;

    }
}
