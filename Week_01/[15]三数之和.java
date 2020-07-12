//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2359 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null && nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int c = 0; c < nums.length - 2; c++) {
            if (nums[c] > 0) {
                break;
            }
            if (c > 0 && nums[c] == nums[c - 1]) {
                continue;//去重
            }
            int a = c + 1, b = nums.length - 1;
            while (a < b) {
                int sum = nums[c] + nums[a] + nums[b];
                if (sum < 0) {
                    a++;
                } else if (sum > 0) {
                    b--;
                } else {
                    res.add(Arrays.asList(nums[c], nums[a], nums[b]));
                    while (a < b && nums[a] == nums[++a]) ;//去重
                    while (a < b && nums[b] == nums[--b]) ;//去重
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
