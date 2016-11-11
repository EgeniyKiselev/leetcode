package my.ek;

/**
 * Created by ekiselev on 29.09.2016.
 */
public class LongestSubstringWithoutRepeating {

//  Time  Complexity: O(2n) = O(n)
//  Space Complexity: O(m)
//    todo optimize it. remove second for loop
    public int lengthOfLongestSubstring(String s) {
        boolean[] buf = new boolean[256];
        int res = 0;
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (buf[ch]) {
                res = Math.max(res, i - pointer);
                for (int j = pointer; j < i; j++) {
                    char c = s.charAt(j);
                    pointer++;
                    if (c == ch) {
                        break;
                    }
                    buf[c] = false;
                }
            } else {
                buf[ch] = true;
            }
        }
        return Math.max(res, s.length() - pointer);
    }
}
