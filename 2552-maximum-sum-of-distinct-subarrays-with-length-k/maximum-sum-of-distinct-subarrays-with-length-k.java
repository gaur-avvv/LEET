import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                int left = nums[i - k];
                currentSum -= left;
                freqMap.put(left, freqMap.get(left) - 1);
                if (freqMap.get(left) == 0) freqMap.remove(left);
            }

            if (i >= k - 1 && freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}