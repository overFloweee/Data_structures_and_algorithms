package study;

public class P57_杨辉三角_记忆法
{
    public static void main(String[] args)
    {
        print(3);

    }


    public static void print(int n)
    {

        int[] row = new int[n];
        for (int i = 0; i < n; i++)
        {
            createRow(row, i);
            for (int j = 0; j <= i; j++)
            {
                System.out.printf("%-4d", row[j]);
            }
            System.out.println();
        }
    }

    private static void createRow(int[] row, int n)
    {
        if (n == 0)
        {
            row[0] = 1;
            return;
        }

        for (int i = n; i > 0; i--)
        {
            row[i] = row[i] + row[i - 1];
        }

    }



}
