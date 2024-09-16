package exam;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author qifei
 * @since 2024-09-05
 */
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 5, 12, 20, 2, 77);
        ArrayList<Integer> arrayList = new Main().newArray(list);
        System.out.println(arrayList);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型ArrayList
     * @return int整型ArrayList
     */
    public ArrayList<Integer> newArray(ArrayList<Integer> a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : a) {
            String str = String.valueOf(num);
            char[] array = str.toCharArray();

            StringBuilder sb = new StringBuilder();
            for (char c : array) {
                if (c != '2') {
                    sb.append(c);
                }
            }
            String res = sb.toString();
            if (!res.isEmpty()) {
                list.add(Integer.valueOf(res));
            }
        }
        return list;
    }
}
