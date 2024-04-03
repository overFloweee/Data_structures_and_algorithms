package study;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-03-19
 */
public class PREV_282
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1)
        {
            System.out.println(1);
            System.exit(0);
        }

        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);

        int sum = 1;
        for (int i = 1; i < n; i++)
        {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                {
                    cur.add(1);
                    continue;
                }
                int temp = prev.get(j) + prev.get(j - 1);

                if (temp == n)
                {
                    System.out.println(sum + j + 1);
                    System.exit(0);
                }
                cur.add(temp);


            }
            prev = cur;
            sum = sum + i + 1;
        }


    }
}
