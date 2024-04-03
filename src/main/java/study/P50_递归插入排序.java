package study;

import java.util.Arrays;

public class P50_递归插入排序
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{2, 4, 9, 6, 1};
        // int[] ints = sort1(arr, 1);
        // System.out.println(Arrays.toString(ints));


        int[] ints1 = sort2(arr, 1, 3, 1 + 1);
        System.out.println(Arrays.toString(ints1));


    }

    // 插入排序
    private static int[] sort1(int[] a, int low)
    {
        if (low == a.length)
        {
            return a;
        }

        int t = a[low];  // 插入元素
        int i = low - 1; // 已排序的右边界
        while (i >= 0 && a[i] > t)
        {
            a[i + 1] = a[i];
            i--;
        }

        // 如果插入值 大于等于当前值，则说明找到了插入位置
        a[i + 1] = t;
        return sort1(a, low + 1);
    }


    // 区域 使用 插入排序
    private static int[] sort2(int[] a, int index, int end, int low)
    {
        if (low > end)
        {
            return a;
        }

        int t = a[low];  // 插入元素
        int i = low - 1; // 已排序的右边界
        while (i >= index && a[i] > t)
        {
            a[i + 1] = a[i];
            i--;
        }

        // 如果插入值 大于等于当前值，则说明找到了插入位置
        a[i + 1] = t;

        return sort2(a, index, end, low + 1);
    }



}
