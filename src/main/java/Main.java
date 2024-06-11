import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String str = sc.next();
        int n = str.length();

        StringBuilder sb = new StringBuilder();
        for (int i = n - k; i < n; ++i) {
            sb.append(str.charAt(i));
        }

        for (int i = 0; i < n - k; ++i) {
            sb.append(str.charAt(i));
        }

        System.out.println(sb);
    }


}
