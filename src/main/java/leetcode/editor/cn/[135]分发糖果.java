import java.util.Arrays;

class Solution {
    // 初解 - 没解出来
    public int candy1(int[] ratings) {
        int n = ratings.length;

        int sum = 1;

        int[] arr = new int[n];
        arr[0] = 1;

        int index = -1;
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
                index = i;
            }
            else if (ratings[i] == ratings[i - 1]) {
                arr[i] = 1;
                index = i - 1;
            }
            else if (ratings[i] < ratings[i - 1] && arr[i - 1] == 1) {
                for (int j = i - 1; j > index; --j) {
                    arr[j] = arr[j] + 1;
                    if (arr[index - 1] == arr[j] && j == index + 1) {

                    }
                }
                arr[i] = 1;
            }
            else {
                arr[i] = 1;
            }
        }
        return Arrays.stream(arr).sum();
    }


    // 官解
    public int candy2(int[] ratings) {
        // [1,2,2,5,4,3,2]

        int n = ratings.length;

        // [1,0,0,0,0,0,0]
        int[] arr = new int[n];
        arr[0] = 1;
        // 1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
            else {
                arr[i] = 1;
            }
        }
        // [1,2,1,2,1,1,1]

        // 2、起点下标 ratings.length - 2 从右往左
        // 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大）
        // 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }


    // 二刷 - 在第二个for循环理解上还差点
    // 第一遍for，保证的是递增方向的元素，能够更大；但是不能保证递减方向的值比右边大
    // 第二遍for循环，从后往前，要保证在递增的方向，值能够更大，那就需要取Math.max
    // 去比较原值，和该次遍历+1后的值
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] arr = new int[n];
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
            else {
                arr[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i + 1] + 1, arr[i]);
            }
        }

        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }

}
