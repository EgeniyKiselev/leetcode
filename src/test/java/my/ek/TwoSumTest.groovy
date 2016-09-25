package my.ek

import spock.lang.Specification

/**
 * Created by ekiselev on 24.09.2016.
 */
class TwoSumTest extends Specification {
    def "TwoSum"() {
        given:
            TwoSum sum = new TwoSum();
            int[] input = [2, 7, 11, 15];
        expect:
            sum.twoSum(input, 9) == [0, 1];
            sum.twoSum(input, 17) == [0, 3];
    }
}
