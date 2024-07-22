import java.util.Arrays;

class Solution {

    // 初解
    // 56.70%
    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[3];  // 5/10/20

        for (int i = 0; i < bills.length; ++i) {
            int back = bills[i] - 5;

            if (back == 0) {
                arr[0] += 1;
            }
            else if (back == 5) {
                if (arr[0] == 0) {
                    return false;
                }
                arr[0] -= 1;
                arr[1] += 1;
            }
            else {
                if (arr[0] >= 1 && arr[1] >= 1) {
                    arr[0] -= 1;
                    arr[1] -= 1;
                    arr[2] += 1;
                }
                else if (arr[0] >= 3) {
                    arr[0] -= 3;
                    arr[2] += 1;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean lemonadeChange(int[] bills) {
        Arrays.stream(bills).boxed().sorted((n1, n2) -> n1[1] - n2[1]).mapToInt(Integer::intValue)
                .toArray()

        IntStream.of(bills).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::intValue)
                .toArray();

        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; ++i) {

            if (bills[i] == 5) {
                five += 1;
            }
            else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five -= 1;
                ten += 1;
            }
            else {
                if (five >= 1 && ten >= 1) {
                    five -= 1;
                    ten -= 1;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
