package exam1;

import java.util.PriorityQueue;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();

        int[] days = new int[n];
        int[] fb = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fb[i] = in.nextInt();
        }

        // ArrayList<Integer> dayPlusList = new ArrayList<>();
        // ArrayList<Integer> dbPlusList = new ArrayList<>();
        PriorityQueue<Integer> dayPlusList = new PriorityQueue<>();
        PriorityQueue<Integer> dbPlusList = new PriorityQueue<>();
        int max = 0;
        int targetDay = 0;
        for (int i = 0; i < n; i++) {
            dayPlusList.add(days[i]);
            dbPlusList.add(fb[i]);
            int num = 0;
            for (int j = 0; j <= i; j++) {
                // num += dayPlusList.get(j) * dbPlusList.get(j);
            }

            max = Math.max(max, num);
            if (max >= m) {
                targetDay = i + 1;
                break;
            }
        }

        if (max >= m) {
            System.out.println(targetDay);
        }
        else {
            System.out.println(-1);
        }
    }
}
