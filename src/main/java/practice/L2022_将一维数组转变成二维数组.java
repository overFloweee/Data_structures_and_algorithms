package practice;

public class L2022_将一维数组转变成二维数组
{
    public static void main(String[] args)
    {

    }


    public int[][] construct2DArray(int[] original, int m, int n)
    {
        if (original.length != m * n)
        {
            return new int[][]{};
        }
        int[][] array = new int[m][];

        for (int i = 0; i < m; i++)
        {
            int[] ints = new int[n];
            System.arraycopy(original, n * i, ints, 0, n);
            array[i] = ints;
        }

        return array;
    }
}
