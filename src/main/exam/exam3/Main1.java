package exam3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tree = in.next();
        int n = in.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }

        list.sort((str1, str2) -> {
            int n1 = str1.length();
            int n2 = str2.length();
            int len = 0;
            if (n1 < n2) {
                len = n1;
            }
            else {
                len = n2;
            }
            for (int i = 0; i < len; i++) {
                char char1 = str1.charAt(i);
                char char2 = str2.charAt(i);
                if (char1 == char2) {
                    continue;
                }

                if (tree.indexOf(char1) <= tree.indexOf(char2)) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            if (len == n1) {
                return -1;
            }
            else {
                return 1;
            }
        });

        for (String string : list) {
            System.out.println(string);
        }

    }
}
