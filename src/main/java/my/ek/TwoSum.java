package my.ek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ekiselev on 24.09.2016.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int pos = target - nums[i];
            if (map.containsKey(pos)) {
                return new int[]{map.get(pos), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("Should be at least one solution.");
    }
}
