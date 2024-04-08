package exam.meituan_jishu5_2024_4_6;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-06
 */
public class exam1
{
    /**
     * 题目描述
     * 小美拿到了一个由复数组成的数组，她想知道其中有多少个实数？
     * <p>
     * 实数：有理数和无理数的总称。其中无理数是无限不循环小数，有理数包括整数和分数。
     * <p>
     * 输入描述
     * 第一行输入一个正整数，代表数组的大小。
     * 第二行输入
     * 个复数，代表小美拿到的数组。
     * <p>
     * 后台数据保证复数为
     * 或者
     * 的形式，其中
     * 和
     * 为绝对值不超过
     * 的整数。
     * 输出描述
     * 一个整数，代表实数的数量。
     * <p>
     * 样例
     * <p>
     * 输入
     * 4
     * -5 5-i 6+3i -4+0i
     * <p>
     * 输出
     * 2
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++)
        {
            String s = scanner.next();
            if (query(s))
            {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean query(String s)
    {
        // 判断当前复数是否为实数
        int m = s.length();
        if (s.charAt(m - 1) != 'i')
        {
            return true;  // 当前实数无虚部
        }
        if (m == 1)
        {
            return false;  // 当前实数是纯虚数i
        }
        if (s.charAt(m - 2) == '+' || s.charAt(m - 2) == '-')
        {
            return false;  // 当前实数的虚部为1/-1
        }
        int j = 0, flag = 0, sum = 0;  // 使用sum来记录虚部的系数，如果sum=0，说明为实数
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
        {
            j++;
        }
        for (; j < m; j++)
        {
            if (s.charAt(j) == '-' || s.charAt(j) == '+')
            {
                flag = 1;
            }
            else if (flag != 0 && s.charAt(j) >= '0' && s.charAt(j) <= '9')
            {
                sum = sum * 10 + s.charAt(j) - '0';
            }
        }
        return sum == 0;
    }


}
