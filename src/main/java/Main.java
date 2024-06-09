import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4}; // 你的int数组
        int[] array = Arrays.stream(intArray).sorted().toArray();

        System.out.println(Arrays.toString(array));

        // String str1 = "this     is text";
        // String str2 = "this  \n   is text";
        // String regex = "this\\s+is\\s+text";
        // System.out.println("============");
        // System.out.println(str1.matches(regex));
        // System.out.println(str2.matches("^this\\s+is\\s+text$"));
        // System.out.println("======  * ========");
        // System.out.println("z".matches("zo*"));
        // System.out.println("zoo".matches("zo*"));
        // System.out.println("======  + ========");
        // System.out.println("z".matches("zo+")); // false
        // System.out.println("zo".matches("zo+"));
        // System.out.println("zoooooo".matches("zo+"));
        // System.out.println("======  ?  =======");
        // System.out.println("do".matches("do(es)?"));
        // System.out.println("does".matches("do(es)?"));
        // System.out.println("======  {n,m}  =======");
        // System.out.println("ooo".matches("o{1}"));  // false
        // System.out.println("ooo".matches("o{2}")); // false
        // System.out.println("ooo".matches("o{3}"));
        // System.out.println("ooo".matches("o{1,}")); // 至少匹配一次
        // System.out.println("ooo".matches("o{1,3}"));
        // System.out.println("======  ?  =======");
        // System.out.println("oooo".matches("o+?"));
        //
        // String line = "This order was placed for QT3000! OK?";


        // List<String> list = new ArrayList<>();
        // Collections.addAll(list, "qwe", "asd");
        // Object[] array = list.toArray();
        // String[] array1 = list.toArray(new String[0]);
        // System.out.println(Arrays.toString(array));
        // System.out.println(Arrays.toString(array1));

        String s = "the sky is blue";
        String[] arr = s.trim().split("\\s+");

        List<String> list = Arrays.asList(arr);
        int n = list.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String temp = list.get(i);
            list.set(i, list.get(n - i - 1));
            list.set(n - i - 1, temp);
            if (i < n / 2) {
                sb.append(list.get(i)).append(" ");
            }
            else {
                sb.append(list.get(n - i - 1));
                if (i != n - 1) {
                    sb.append(" ");
                }
            }
        }

        System.out.println(sb.toString());

    }
}
