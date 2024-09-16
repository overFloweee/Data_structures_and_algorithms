package exam3;

import java.util.Arrays;
import java.util.List;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class demo {
    public static void main(String[] args) {
        // List<Integer> list = Arrays.asList(64, 34, 25, 12, 22, 11, 90);
        //
        // list.sort((n1, n2) -> {
        //     System.out.println(n1 + ":" + n2);
        //     if (n1 > n2) {
        //         return -1;
        //     }
        //     else {
        //         return 1;
        //
        //     }
        // });
        //
        // System.out.println(list);


        List<String> list = Arrays.asList("aa", "ab", "bb", "aaa");

        list.sort((n1, n2) -> {
            return n1.compareTo(n2);
        });

        System.out.println(list);
    }
}
