import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {

    // I saw this in a YT video. and I liked how it solved the twosum problem
    // efficiently with O(n) complexity.
    public static void main(String[] args) {
        int[] nums = { 3, 2, 5, 4, 5 };
        int[] res = twoSumIndex(nums, 8);

        if (res != null) {
            for (int idx : res) {
                System.out.print(idx);
            }
        } else {
            System.out.println("TwoSum not found.");
        }
    }

    /**
     * sample comment.
     * @param nums hehehehe
     * @param target secret
     * @return [int, int] if sum is found or Null if no sum is found.
     * 
     */
    private static int[] twoSumIndex(int[] nums, int target) {
        int[] idx_arr = new int[2];

        HashMap<Integer, Integer> mapped_array = new HashMap<>();

        for (int idx = 0; idx < nums.length; idx++) {
            int complement = target - nums[idx];

            if (mapped_array.containsKey(complement)) {
                idx_arr[0] = mapped_array.get(complement);
                idx_arr[1] = idx;

                return idx_arr;
            }

            mapped_array.put(nums[idx], idx);
        }

        return null;
    }
}
