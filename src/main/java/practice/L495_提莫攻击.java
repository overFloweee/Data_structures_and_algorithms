package practice;

public class L495_提莫攻击
{
    public static void main(String[] args)
    {
        int[] timeSeries = {1,2,3,4,5,6,7,8,9};
        int duration = 0;
        System.out.println(new L495_提莫攻击().findPoisonedDuration(timeSeries, duration));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration)
    {
        int sum = 0;
        for (int i = 0; i < timeSeries.length - 1; i++)
        {
            int j = timeSeries[i + 1] - timeSeries[i];
            if (j >= duration)
            {
                sum += duration;
            }
            else
            {
                sum += j;
            }
        }
        sum += duration;
        return sum;
    }
}
