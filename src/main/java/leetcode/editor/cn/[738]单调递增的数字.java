class Solution {
    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        int len = arr.length;
        int index = n;
        for(int i = len - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                arr[i]--;
                index  = i + 1;
            }
        }

        for (int i = index; i < n; ++i) {
            arr[i] = '9';
        }

        str = new String(arr);
        return Integer.valueOf(str);
    }
}
