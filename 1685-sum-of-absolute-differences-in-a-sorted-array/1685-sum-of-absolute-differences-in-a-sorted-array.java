class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        // Compute total sum of the array for suffix sum calculations
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            // Left contribution: (nums[i] * i) - prefixSum
            int leftDiff = nums[i] * i - leftSum;
            
            // Right contribution: suffixSum - (nums[i] * (n - i - 1))
            int rightDiff = rightSum - nums[i] * (n - i - 1);
            
            result[i] = leftDiff + rightDiff;
            
            // Update leftSum for the next iteration
            leftSum += nums[i];
        }
        
        return result;
    }
}