import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put((long) num, counts.getOrDefault((long) num, 0) + 1);
        }

        int maxLen = 0;

        if (counts.containsKey(1L)) {
            int oneCount = counts.get(1L);
            if (oneCount % 2 == 0) {
                maxLen = oneCount - 1;
            } else {
                maxLen = oneCount;
            }
        }

        for (long x : counts.keySet()) {
            if (x == 1) continue;

            int currentLen = 0;
            long current = x;

            while (counts.containsKey(current) && counts.get(current) >= 2) {
                currentLen += 2;
                current = current * current; 
                if (current > 1000000000L) {
                    break;
                }
            }

            if (counts.containsKey(current)) {
                currentLen += 1;
            } else {
                currentLen -= 1;
            }

            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}