package sort;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        // 选择最右侧的元素作为基准
        int pivot = array[right];
        int partitionIndex = left;

        for (int i = left; i < right; i++) {
            if (array[i] < pivot) {
                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        // 将基准元素放到正确的位置
        swap(array, partitionIndex, right);
        return partitionIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void mergeSort(int[] array) {
        if (array == null) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] leftTemp = new int[mid - left + 1];
        int[] rightTemp = new int[right - mid];

        System.arraycopy(array, left, leftTemp, 0, leftTemp.length);
        System.arraycopy(array, mid + 1, rightTemp, 0, rightTemp.length);

        int i = 0, j = 0, k = left;
        while (i < leftTemp.length && j < rightTemp.length) {
            if (leftTemp[i] <= rightTemp[j]) {
                array[k++] = leftTemp[i++];
            }
            else {
                array[k++] = rightTemp[j++];
            }
        }

        while (i < leftTemp.length) {
            array[k++] = leftTemp[i++];
        }

        while (j < rightTemp.length) {
            array[k++] = rightTemp[j++];
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // 外层循环控制排序的轮数
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // 存储当前要插入的元素
            int j = i - 1;

            // 将大于key的元素向后移动一个位置
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // 将key插入到正确位置
            arr[j + 1] = key;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换 arr[j] 和 arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // 外层循环控制排序的轮数
        for (int i = 0; i < n - 1; i++) {
            // 假设当前位置是最小值
            int minIndex = i;
            // 内层循环用于找到实际的最小值
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 更新最小值的位置
                }
            }
            // 将找到的最小值和当前位置的值交换
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
