package exam1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-06
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

        for (String string : arr) {
            System.out.println(string + " ");
        }

    }


}
