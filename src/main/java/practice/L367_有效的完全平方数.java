package practice;


// 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
public class L367_有效的完全平方数
{
    public static void main(String[] args)
    {
        System.out.println(new L367_有效的完全平方数().isPerfectSquare(2147483647));
    }

    // *
    public boolean isPerfectSquare(int num)
    {
        if (num == 1)
        {
            return true;
        }
        for (long i = 1; i <= num; i++)
        {
            if (i * i >= num)
            {
                if (i * i == num)
                {
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    // 暴力
    public boolean isPerfectSquare1(int num)
    {
        // * 变量都要为 long
        long square = 1;
        for (long i = 1; square <= num; i++)
        {
            if (square == num)
            {
                return true;
            }
            square = i * i;

        }
        return false;


        // long x = 1, square = 1;
        // while (square <= num) {
        //     if (square == num) {
        //         return true;
        //     }
        //     ++x;
        //     square = x * x;
        // }
        // return false;
    }


    // 二分查找
    public boolean isPerfectSquare2(int num)
    {
        if (num == 1)
        {
            return true;
        }
        int i = 0, j = num - 1;
        while (i <= j)
        {
            int mid = (i + j) >>> 1;
            long square = (long) mid * mid;
            if (square < num)
            {
                i = mid + 1;
            }
            else if (square > num)
            {
                j = mid - 1;
            }
            else
            {
                return true;
            }
        }
        return false;

    }

}


