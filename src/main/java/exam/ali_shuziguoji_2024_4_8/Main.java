package exam.ali_shuziguoji_2024_4_8;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-08
 */
public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();

        String[][] arr = new String[l][l];
        for (int i = 0; i < l; ++i)
        {
            String temp = in.next();
            for (int j = 0; j < l; j++)
            {
                arr[i][j] = temp.charAt(j) + "";
            }
        }
        int m = in.nextInt();
        int n = in.nextInt();

        int len = arr.length;

        if (l == 1)
        {
            System.out.println(1);
        }

        int p1 = m;
        int p2 = n;
        int size = 0;
        while (true)
        {
            String t = arr[p1 - 1][p2 - 1];

            if (t.equals(">"))
            {

                arr[p1 - 1][p2 - 1] = "<";
                p2++;

            }
            else if (t.equals("v"))
            {
                arr[p1 - 1][p2 - 1] = "^";
                p1++;

            }
            else if (t.equals("<"))
            {

                arr[p1 - 1][p2 - 1] = ">";
                p2--;

            }
            else
            {

                arr[p1 - 1][p2 - 1] = "v";
                p1--;

            }

            size++;

            if (p1 > l || p1 <= 0)
            {
                System.out.println(size);
                break;
            }
            if (p2 > l || p2 <= 0)
            {
                System.out.println(size);
                break;
            }
            if (size > l * l + 1)
            {
                System.out.println(-1);
                break;
            }

        }
    }
}
