package study;

public class P7_二分查找_改动版
{
    public static void main(String[] args)
    {

        int[] ints = {1, 2, 4, 6, 7, 78, 99};
        int index = search_binary_modify(ints, 6);
        System.out.println(index);


    }


    public static int search_binary_modify(int[] arr, int target)
    {
        int i = 0, j = arr.length;
        while (i < j)
        {
            int m = (i + j) >>> 1;
            if (target < arr[m])
            {            // 在左边
                j = m;
            }
            else if (arr[m] < target)
            {        // 在右边
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
