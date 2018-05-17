package io.cabin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jianlong.zzy
 * @date 2018/05/17
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class Problem13 {
     class Solution {
        private final Map<Character, Integer> roman2IntMap = new HashMap<>();

        public Solution() {
            roman2IntMap.put('I', 1);
            roman2IntMap.put('V', 5);
            roman2IntMap.put('X', 10);
            roman2IntMap.put('L', 50);
            roman2IntMap.put('C', 100);
            roman2IntMap.put('D', 500);
            roman2IntMap.put('M', 1000);
        }

        public int romanToInt(String s) {
            Integer integer = roman2IntMap.get(s);
            if (integer != null) {
                return integer;
            }
            Integer result = 0;
            for (int i = 0; i < s.length(); ) {
                int one = roman2IntMap.get(s.charAt(i));
                if (i + 1 < s.length()) {
                    int two = roman2IntMap.get(s.charAt(i + 1));
                    if (two > one) {
                        result += two - one;
                        i += 2;
                    } else {
                        result += one;
                        i++;
                    }
                } else {
                    result += one;
                    i++;
                }
            }
            return result;
        }
    }

}
