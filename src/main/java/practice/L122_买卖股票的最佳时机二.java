package practice;

/**
 * @author qifei
 * @since 2024-04-02
 */
public class L122_买卖股票的最佳时机二
{
    public static void main(String[] args)
    {
        int[] a = new int[]{2, 1, 2, 0, 1};
        System.out.println(new L122_买卖股票的最佳时机二().maxProfit(a));
    }

    public int maxProfit(int[] prices)
    {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int sum = 0;
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
                    if (i < prices.length - 2 && max > prices[i + 1] - min)
                    {
                        sum += max;
                        min = prices[i];
                        max = 0;
                    }
                }
            }

        }
        sum += max;
        return sum;

    }
}
