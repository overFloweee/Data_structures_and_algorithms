package practice;

import java.util.Arrays;

public class L88_合并两个有序数组
{
    public static void main(String[] args)
    {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new L88_合并两个有序数组().merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n)
    {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int index = 0;
        int temp = 0;
        while (p1 < m || p2 < n)
        {
            if (p1 == m)
            {
                temp = nums2[p2++];
            }
            else if (p2 == n)
            {
                temp = nums1[p1++];
            }
            else if (nums1[p1] < nums2[p2])
            {
                temp = nums1[p1++];
            }
            else
            {
                temp = nums2[p2++];
            }
            sorted[index++] = temp;
        }

        for (int i = 0; i < m + n; i++)
        {
            nums1[i] = sorted[i];
        }
    }

    // ** 逆向双指针
    public void merge2(int[] nums1, int m, int[] nums2, int n)
    {
        int p1 = m - 1, p2 = n - 1;
        int index = nums1.length - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0)
        {
            if (p1 == -1)
            {
                cur = nums2[p2--];
            }
            else if (p2 == -1)
            {
                cur = nums1[p1--];
            }
            else if (nums1[p1] < nums2[p2])
            {
                cur = nums2[p2--];
            }
            else
            {
                cur = nums1[p1--];
            }
            nums1[index--] = cur;
        }

    }

    public void merge3(int[] nums1, int m, int[] nums2, int n)
    {


        int p1 = m == 0 ? 0 : m - 1;
        int p2 = n - 1;
        int index = m + n - 1;
        while (p2 >= 0 || p1 >= 0)
        {
            if (p1 == -1)
            {
                System.arraycopy(nums2, 0, nums1, 0, index + 1);
                break;
            }


            int s1 = nums1[p1];
            int s2 = nums2[p2];
            if (s1 > s2)
            {
                nums1[index] = s1;
                index--;
                p1--;
            }
            else
            {
                nums1[index] = s2;
                index--;
                p2--;
            }


        }
    }

}
