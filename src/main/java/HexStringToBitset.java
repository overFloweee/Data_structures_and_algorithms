public class HexStringToBitset {
    public static int[] hexStrToBitset(String s) {
        int[] bitArray = new int[64];
        if (s.length() != 16) {
            throw new IllegalArgumentException("Input string must be 16 characters long.");
        }

        for (int i = 0; i < 16; i++) {
            char c = s.charAt(i);
            int val;
            if (c >= '0' && c <= '9') {
                val = c - '0';
            }
            else if (c >= 'A' && c <= 'F') {
                val = c - 'A' + 10;
            }
            else if (c >= 'a' && c <= 'f') {
                val = c - 'a' + 10;
            }
            else {
                throw new IllegalArgumentException("Invalid hexadecimal character: " + c);
            }

            // 将当前十六进制数字转换为4位二进制并设置到bits中
            for (int j = 0; j < 4; j++) {
                bitArray[i * 4 + j] = (val >> (3 - j)) & 1;
            }
        }

        return bitArray;
    }

    public static void main(String[] args) {
        String hexString = "0123456789ABCDEF"; // 示例十六进制字符串
        try {
            int[] ints = hexStrToBitset(hexString);
            for (int anInt : ints) {
                System.out.print(anInt);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
