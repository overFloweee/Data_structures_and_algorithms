package demo;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-07
 */
public class demo3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();

        int n = str.length();
        int p1 = 0, p2 = 0, p3 = 0;
        for (int i = 0; i < n; i++)
        {
            if (str.charAt(i) == 'r')
            {
                p1 = i;
            }
            else if (str.charAt(i) == 'e')
            {
                p2 = i;
            }
            else if (str.charAt(i) == 'd')
            {
                p3 = i;
            }
        }

    }
}
