import java.util.HashSet;

class Solution {

    Set<String> set;
    int[] flag;
    // 回溯
    public boolean wordBreak(String s, List<String> wordDict) {
        flag = new int[s.length()];
        set = new HashSet<>(wordDict);

        return backTracking(s, 0);
    }

    public boolean backTracking(String s, int index) {
        if (index == s.length()) {
            return true;
        }

        if (flag[index] == -1) {
            return false;
        }

        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (!set.contains(str)) {
                continue;
            }
            boolean res = backTracking(s, i + 1);
            if (res) {
                return true;
            }
        }
        flag[index] = -1;
        return false;
    }
}
