package study;

import java.util.Arrays;

public class P48_冒泡排序递归
{

    public static void main(String[] args)
    {
        int[] arr = new int[]{4, 2, 6, 9, 1};
        int[] ints = sort1(arr, arr.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    // 冒泡递归
    private static int[] sort1(int[] arr, int end)
    {
        if (end == 0)
        {
            return arr;
        }
        int temp;
        for (int i = 0; i < end; i++)
        {
            if (arr[i + 1] < arr[i])
            {
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        return sort1(arr, end - 1);

    }


    // 冒泡递归 升级版
    private static int[] sort2(int[] arr, int end)
    {
        if (end == 0)
        {
            return arr;
        }
        int x = 0;   // x代表未排序的右边界
        int temp;
        for (int i = 0; i < end; i++)
        {
            if (arr[i + 1] < arr[i])
            {
                x = i;
                temp = arr[i + 1];
                arr[i + 1] = arr[i];
                arr[i] = temp;
            }
        }
        return sort1(arr, x);

    }
}
