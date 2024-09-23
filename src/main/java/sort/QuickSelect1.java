package sort;

/**
 * @author qifei
 * @since 2024-09-20
 */
public class QuickSelect1 {

    public static void main(String[] args) {
        //           1, 2, 3, 4, 5, 7, 8, 9
        int[] arr = {5, 3, 7, 2, 9, 8, 1, 4};
        int k = 3;
        int res = quickSelect(arr, k);
        System.out.println(res);
    }

    public static int quickSelect(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (true) {
            if (left == right) {
                return arr[left];
            }
            int partitionIndex = partition(arr, left, right);

            // 第 k 大的元素，则位置为 n - k，如果与基准位置相等，则成功找到
            if (partitionIndex == arr.length - k) {
                return arr[partitionIndex];
            }
            else if (partitionIndex < arr.length - k) {
                // 如果基准位置 < 目标位置，则对右边区域继续分治
                left = partitionIndex + 1;
            }
            else {
                // 如果基准位置 > 目标位置，则对左边区域继续分治
                right = partitionIndex - 1;
            }
        }

    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int partitionIndex = left;

        // 将小于基准元素的挪到左边
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, partitionIndex, i);
                partitionIndex++;
            }
        }

        // 交换基准元素
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
