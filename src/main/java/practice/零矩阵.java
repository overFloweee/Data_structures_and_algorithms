package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qifei
 * @since 2024-05-06
 */
public class 零矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};

        List<Integer> list = new ArrayList<>();


        longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    // LSP(S1,S2)
    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        String longStr = strs[0];
        for (int i = 1; i < n; ++i) {
            longStr = LSP(longStr, strs[i]);
        }

        return longStr;
    }

    public static String LSP(String s1, String s2) {
        if (s1.length() > s2.length()) {
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        int n = s1.length();

        for (int i = 0; i < n; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                s1.substring(0, i);
            }
        }
        return s1;

    }
}
