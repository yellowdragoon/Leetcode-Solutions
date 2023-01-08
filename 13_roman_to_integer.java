/*
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV.
Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.


Solution:
We use a hashmap to store each numeral's priority and value, and iterate over the characters.
When we encounter a lower priority letter, we can add the last value to running total.
Else, we need to subtract since the last letter was a decremental counter.
 */

import java.util.HashMap;

class Solution {
    public int romanToInt(String s) {

        int lastPriority = 8;
        int total = 0;
        int prev = 0;

        HashMap<Character, Integer[]> letterEncodings = new HashMap<Character, Integer[]>();

        letterEncodings.put('I', new Integer[]{1, 1});
        letterEncodings.put('V', new Integer[]{2, 5});
        letterEncodings.put('X', new Integer[]{3, 10});
        letterEncodings.put('L', new Integer[]{4, 50});
        letterEncodings.put('C', new Integer[]{5, 100});
        letterEncodings.put('D', new Integer[]{6, 500});
        letterEncodings.put('M', new Integer[]{7, 1000});

        char[] charArr = s.toCharArray();

        for(char c: charArr){
            int priority = letterEncodings.get(c)[0];

            if(priority <= lastPriority){
                total += prev;
            }

            else{
                total -= prev;
            }
            prev = letterEncodings.get(c)[1];
            lastPriority = priority;
        }
        total += prev;
        return total;
    }
}