package exam.ali_shuziguoji_2024_4_8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-04-08
 */
public class demo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            int a = in.nextInt();
            arr[i] = a;
        }

        boolean[] v = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            if (v[i])
            {
                continue;
            }

            HashSet<Integer> set = new HashSet<>();

            int q = i;
            while (!v[i])
            {
                set.add(q);
                v[i] = true;
                q = arr[i];
            }

        }


        System.out.println(Arrays.toString(arr));
    }
}
