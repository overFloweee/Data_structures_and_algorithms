class Solution1 {

    public static void main(String[] args) {
        System.out.println(new Solution1().monotoneIncreasingDigits(1234));
        // System.out.println(new Solution1().largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        // System.out.println(new Solution1().largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }

    public int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char[] arr = str.toCharArray();

        int len = arr.length;
        for (int i = len - 2; i >= 0; --i) {
            int cur = arr[i] - '0';
            int next = arr[i + 1] - '0';
            if (cur > next) {
                arr[i]--;
                arr[i + 1] = '9';
            }
        }

        str = new String(arr);
        return Integer.parseInt(str);
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num < 0 && k > 0) {
                nums[i] = -1 * num;
                k--;
            }
            else if (k % 2 != 0) {
                nums[i] = -1 * num;
                k--;
            }
            sum += nums[i];
        }
        return sum;
    }
}
