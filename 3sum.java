import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Sort the array to use two pointers and handle duplicates
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the smallest number is > 0, no triplet can sum to 0
            if (nums[i] > 0) break;
            
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                
                if (total == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (total < 0) {
                    left++; // Sum is too small, move left pointer right
                } else {
                    right--; // Sum is too big, move right pointer left
                }
            }
        }
        
        return result;
    }
                  }
