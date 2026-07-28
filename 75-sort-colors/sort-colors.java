class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left =  0;
        int mid = 0;
        int right = n-1;

        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;

                left++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                int temp = nums[right];
                nums[right] = nums[mid];
                nums[mid] = temp;
                
                right--;
            }
        }
    }
}