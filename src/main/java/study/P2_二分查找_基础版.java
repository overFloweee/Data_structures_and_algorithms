package study;

import java.util.Arrays;

public class P2_二分查找_基础版
{
    public static void main(String[] args)
    {

        int[] ints = {1, 2, 4, 6, 7, 78, 99};
        int index = search_binary_basic(ints, 6);
        System.out.println(index);

    }


    public static int search_binary_basic(int[] arr, int target)
    {
        int len = arr.length;
        int i = 0, j = len - 1;

        while (i <= j)
        {
            int m = (i + j) / 2;
            int Am = arr[m];
            if (target < Am)
            {
                j = m - 1;
            }
            else if (Am < target)
            {
                i = m + 1;
            }
            else
            {
                return m;
            }

        }

        return -1;


    }

}
