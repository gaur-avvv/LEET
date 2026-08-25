class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remCount = new int[k];

        remCount[0] = 1;

        long prefixSum = 0;
        int count = 0;

        for(int num : nums){
            prefixSum += num;

        int rem = (int)(((prefixSum % k) +k) %k);

        count += remCount[rem];

        remCount[rem]++;

        }

        return count;
    }

    
}