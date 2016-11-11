package my.ek

import spock.lang.Specification

/**
 * Created by ekiselev on 29.09.2016.
 */
class LongestSubstringWithoutRepeatingTest extends Specification {
    def "LengthOfLongestSubstring"() {
        given:
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating()
        expect:
        sol.lengthOfLongestSubstring("abcabcbb") == 3
        sol.lengthOfLongestSubstring("bbbbb") == 1
        sol.lengthOfLongestSubstring("pwwkew") == 3
        sol.lengthOfLongestSubstring("pwwkewz") == 4
        sol.lengthOfLongestSubstring("pwwkewzy") == 5
        sol.lengthOfLongestSubstring("pwwkewzyek") == 5
    }
}
