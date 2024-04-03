package practice;

import java.util.HashMap;
import java.util.Map;

public class L13_罗马数字转整数
{
    public static void main(String[] args)
    {
        System.out.println(new L13_罗马数字转整数().romanToInt("MCMXCIV"));
    }


    public int romanToInt1(String s)
    {
        Map<Character, Integer> map = new HashMap<>()
        {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};


        int sum = 0;
        for (int i = 0; i < s.length(); i++)
        {

            Integer p1 = map.get(s.charAt(i));
            if (i == s.length() - 1)
            {
                sum += p1;
                break;
            }
            Integer p2 = map.get(s.charAt(i + 1));
            if (p1 < p2)
            {
                sum += p2 - p1;
                i++;
            }
            else
            {
                sum += p1;
            }
        }
        return sum;
    }

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>()
    {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s)
    {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i)
        {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1)))
            {
                ans -= value;
            }
            else
            {
                ans += value;
            }
        }
        return ans;
    }

}
