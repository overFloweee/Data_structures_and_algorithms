import java.util.*;

public class demo {
    public static void main(String[] args) {
        System.out.println(strStr("leetcode", "leeto"));
    }

    public static int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray();
        char[] partten = needle.toCharArray();

        // 获取前缀表
        int[] lps = getPreTable(partten);
        // System.out.println(Arrays.toString(lps));

        int i = 0;
        int j = 0;
        while (partten.length - j <= origin.length - i) {
            if (origin[i] == partten[j]) {
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            }
            else {
                j = lps[j - 1];
            }

            System.out.println(j);
            // 在j++之后，找到解的情况
            if (j == partten.length) {
                return i - j;
            }
        }
        return -1;
    }

    public static int[] getPreTable(char[] partten) {
        int n = partten.length;
        int[] lps = new int[n];

        int i = 1;
        int j = 0;
        while (i < n) {
            if (partten[i] == partten[j]) {
                lps[i] = j + 1;
                i++;
                j++;
            }
            else if (j == 0) {
                i++;
            }
            else {
                j = lps[j - 1];
            }
        }

        return lps;
    }


}
