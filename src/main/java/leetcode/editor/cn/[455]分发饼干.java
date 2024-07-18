class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int sum = 0;
        int j = 0;
        for(int i = 0; i < g.length;) {
            if (g[i] <= s[j]) {
                sum++;
                i++;
                j++;
            }
            else {
                j++;
            }


            if (j == s.length) {
                return sum;
            }
        }

        return sum;

    }
}
