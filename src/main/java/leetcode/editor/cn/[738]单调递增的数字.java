class Solution {
    public int monotoneIncreasingDigits1(int n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        int len = arr.length;
        int index = n;
        for (int i = len - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                arr[i]--;
                index = i + 1;
            }
        }

        for (int i = index + 1; i < n; ++i) {
            arr[i] = '9';
        }

        str = new String(arr);
        return Integer.valueOf(str);
    }

    // 二刷
    public int monotoneIncreasingDigits(int n) {

        char[] arr = String.valueOf(n).toCharArray();

        int index = arr.length - 1;
        for (int i = arr.length - 2; i >= 0; --i) {
            if (arr[i] > arr[i + 1]) {
                index = i;
                arr[i]--;
            }
        }

        for (int i = index + 1; i < arr.length; ++i) {
            arr[i] = '9';
        }

        return Integer.valueOf(new String(arr));
    }
}
