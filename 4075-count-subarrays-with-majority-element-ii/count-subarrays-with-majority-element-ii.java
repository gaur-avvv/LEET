import java.util.*;

class Solution {
    private int[] bit;
    private int size;

    private void update(int idx, int val) {
        for (; idx <= size; idx += idx & -idx) {
            bit[idx] += val;
        }
    }

    private int query(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum += bit[idx];
        }
        return sum;
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] pref = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sortedPref = pref.clone();
        Arrays.sort(sortedPref);
        
        Map<Integer, Integer> ranks = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sortedPref.length; i++) {
            if (i == 0 || sortedPref[i] != sortedPref[i - 1]) {
                ranks.put(sortedPref[i], rank++);
            }
        }

        this.size = rank;
        this.bit = new int[size + 1];

        long ans = 0;
        for (int p : pref) {
            int r = ranks.get(p);
            ans += query(r - 1);
            update(r, 1);
        }

        return ans;
    }
}