package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        heapSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // 堆排序
    public static void heapSort(int[] arr) {
        // 构建大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));


        // 一个个从堆顶取出元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 将当前堆顶元素与末尾元素交换
            swap(arr, 0, i);
            // 重新调整堆结构
            adjustHeap(arr, 0, i);
        }
    }

    // 调整堆
    private static void adjustHeap(int[] arr, int parent, int size) {
        while (true) {
            // 左右节点索引
            int left = 2 * parent + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && arr[left] > arr[max]) {
                max = left;
            }
            if (right < size && arr[right] > arr[max]) {
                max = right;
            }
            // 循环结束，父节点大
            if (parent == max) {
                break;
            }

            // 子节点大，继续遍历
            swap(arr, parent, max);
            parent = max;
        }
    }

    // 比上面的调整堆更高效，但是更难理解
    // private static void adjustHeap(int[] arr, int i, int length) {
    //     int temp = arr[i];
    //     for (int k = 2 * i + 1; k < length; k = 2 * k + 1) { // k是i的左子节点
    //         if (k + 1 < length && arr[k] < arr[k + 1]) { // 如果右子节点大于左子节点，则k指向右子节点
    //             k++;
    //         }
    //         if (arr[k] > temp) { // 如果子节点大于父节点，则交换
    //             arr[i] = arr[k];
    //             i = k;
    //         } else {
    //             break;
    //         }
    //     }
    //     arr[i] = temp;
    // }

    // 交换数组中的两个元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
