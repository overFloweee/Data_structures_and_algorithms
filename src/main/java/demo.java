import java.util.*;

public class demo {
    public static void main(String[] args) {
        // System.out.println(strStr("leetcode", "leeto"));

        // new demo().combinationSum3(3, 7);
        StringBuilder sb = new StringBuilder("22.33.44");
        System.out.println(sb.lastIndexOf("."));
        System.out.println(sb.delete(5, sb.length()));
        System.out.println();
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


    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        int index = 1;
        int sum = 0;
        method(target, k, index, sum);
        return res;
    }

    public void method(int target, int k, int index, int sum) {

        if (path.size() == k && sum != target) {
            return;
        }
        else if (path.size() == k && sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = index; i <= 9; ++i) {
            sum += i;
            path.add(i);
            method(target, k, i + 1, sum);
            sum -= i;
            path.removeLast();
        }

    }
}
