/*
    Given an integer x, return true if x is palindrome integer.
    An integer is a palindrome when it reads the same backward as forward.
    For example, 121 is a palindrome while 123 is not.
 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        String x_str = Integer.toString(x);
        StringBuilder reversed = new StringBuilder(x_str);
        reversed.reverse();

        if(x_str.equals(reversed.toString())){
            return true;
        }
        else{
            return false;
        }
    }
}