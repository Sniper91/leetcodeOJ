package io.cabin;

import java.util.TreeMap;

/**
 * @author jianlong.zzy
 * @date 2018/05/17
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class Problem12 {

    class Solution {
        private final TreeMap<Integer, String> int2RomanMap = new TreeMap<Integer, String>();

        public Solution() {
            int2RomanMap.put(1, "I");
            int2RomanMap.put(4, "IV");
            int2RomanMap.put(5, "V");
            int2RomanMap.put(9, "IX");
            int2RomanMap.put(10, "X");
            int2RomanMap.put(40, "XL");
            int2RomanMap.put(50, "L");
            int2RomanMap.put(90, "XC");
            int2RomanMap.put(100, "C");
            int2RomanMap.put(400, "CD");
            int2RomanMap.put(500, "D");
            int2RomanMap.put(900, "CM");
            int2RomanMap.put(1000, "M");
        }

        public String intToRoman(int num) {
            String s = int2RomanMap.get(num);
            if (s != null) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (Integer key : int2RomanMap.descendingKeySet()) {
                int t = num / key;
                if (t != 0) {
                    num %= key;
                    for (int i = 0; i < t; i++) {
                        sb.append(int2RomanMap.get(key));
                    }
                }
            }
            return sb.toString();
        }
    }
}
