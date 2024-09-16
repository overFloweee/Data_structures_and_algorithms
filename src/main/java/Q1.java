import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String correctPassword = sc.next();
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            passwords.add(sc.next());
        }
        sc.close();
        long[] ans = getTryNum(n, correctPassword, passwords);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static long[] getTryNum(int n, String correctPassword, List<String> passwords) {
        long[] ans = new long[2];

        // 使用set去重
        Set<String> set = new HashSet<>();
        for (int i = 0; i < passwords.size(); i++) {
            set.add(passwords.get(i));
        }
        List<String> uniPsw = new ArrayList<>(set);

        // 建立长度map
        Map<Integer, Integer> lenMap = new HashMap<>();
        for (int i = 0; i < uniPsw.size(); i++) {
            lenMap.merge(uniPsw.get(i).length(), 1, Integer::sum);
        }

        long minAttempts = 1;
        int len = correctPassword.length();
        for (int i = 1; i < len; i++) {
            if (lenMap.containsKey(i)) {
                minAttempts += lenMap.get(i);
            }
        }

        long maxAttempts = 0;
        if (lenMap.containsKey(len)) {
            maxAttempts += minAttempts + lenMap.get(len) - 1;
        }
        ans[0] = minAttempts;
        ans[1] = maxAttempts;
        return ans;
    }
}
