import java.util.HashMap;
import java.io.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the map and the index difference is <= k
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            // Otherwise, update the map with the current index of the element
            map.put(nums[i], i);
        }
        
        return false;
    }
}