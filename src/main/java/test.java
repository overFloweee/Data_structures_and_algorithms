import java.sql.SQLOutput;
import java.util.*;

public class test
{
    public static void main(String[] args)
    {


        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(1);
        // int[] array = list.stream().mapToInt(i -> i).toArray();

        // String str = "A man, a plan, a canal: Panama";
        // int p1 = 0;
        // int p2 = str.length() - 1;
        // while (p1 <= p2)
        // {
        //     char c1 = str.charAt(p1);
        //     char c2 = str.charAt(p2);
        //     if (!Character.isLetterOrDigit(c1))
        //     {
        //         p1++;
        //         continue;
        //     }
        //     else if (!Character.isLetterOrDigit(c2))
        //     {
        //         p2--;
        //         continue;
        //     }
        //
        //     if (Character.toLowerCase(c1) != Character.toLowerCase(c2))
        //     {
        //         System.out.println("false");
        //     }
        //     p1++;
        //     p2--;
        // }
        //
        // System.out.println("true");
        // System.out.println(8 >> 2);
        // System.out.println(0^2);
        // System.out.println(1^3^1);
        // System.out.println(85119105*85119105);
        // System.out.println(46341*46341);

        // HashMap<Integer, Integer> map = new HashMap<>();
        // System.out.println(map.put(1, 2));
        // System.out.println(map.put(1, 2));
        //
        // List<List<Integer>> arr = generate(30);
        // for (List<Integer> integers : arr)
        // {
        //     System.out.println(integers);
        // }


    }

    // 递归    -> cache记忆法
    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> rows = new ArrayList<>();

        for (int i = 0; i < numRows; i++)
        {

            rows.add(0);
            createRow(rows, i);
            List<Integer> temp = new ArrayList<>(rows);
            list.add(temp);
        }

        return list;
    }

    public static void createRow(List<Integer> row, int n)
    {
        List<Integer> tempRows = new ArrayList<>();

        if (n == 0)
        {
            row.set(0, 1);
            return;
        }

        for (int i = n; i > 0; i--)
        {
            row.set(i, row.get(i) + row.get(i - 1));
        }
    }
}
