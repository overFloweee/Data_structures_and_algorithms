package exam4;

import java.util.Scanner;

/**
 * @author qifei
 * @since 2024-09-14
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int r = str.indexOf('R');
        int b = str.indexOf('B');
        int g = str.indexOf('G');

        int rt = method(b, r, g, str);
        int bt = method(r, b, g, str);
        int gt = method(r, g, b, str);

        System.out.println(rt + " " + bt + " " + gt);
    }

    // 找第一个元素最近的
    private static int method(int a, int target, int b, String str) {
        // a更近
        if (Math.abs(a - target) < Math.abs(b - target)) {
            if (a > target) {
                if (str.substring(target, a + 1).contains("#")) {
                    return method(b, target, a, str);
                }
                else {
                    return a - target;
                }
            }
            else {
                // 如果r在后面
                if (str.substring(a, target + 1).contains("#")) {
                    return -1;
                }
                else {
                    return target - a;
                }
            }
        }
        else {
            // b更近
            // 如果G在后面
            if (b > target) {
                if (str.substring(target, b + 1).contains("#")) {
                    return method(b, target, a, str);
                }
                else {
                    return b - target;
                }
            }
            else {
                // 如果R在后面
                if (str.substring(b, target + 1).contains("#")) {
                    return -1;
                }
                else {
                    return target - b;
                }
            }
        }
    }
}
