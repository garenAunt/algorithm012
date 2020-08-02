//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 519 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4 || nums == null) {
            return res;
        }

        Arrays.sort(nums);

        int l = nums.length;

        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k + 1]) {
                continue;
            }
            if (nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3] > target) {
                break;
            }
            if (nums[k] + nums[l - 3] + nums[l - 2] + nums[l - 1] < target) {
                continue;//
            }
            for (int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i + 1]) {//
                    continue;
                }
                int j = i + 1;
                int h = l - 1;
                if (nums[k] + nums[i] + nums[j] + nums[j + 1] > target) {
                    continue;
                }
                if (nums[k] + nums[i] + nums[h] + nums[h - 1] < target) {
                    continue;
                }
                while (j < h) {
                    int sum = nums[k] + nums[i] + nums[j] + nums[h];
                    if (sum > target) h--;
                    if (sum < target) j++;
                    if (sum == target) {
                        res.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        while (j < h && nums[j] == nums[j + 1]){
                            j++;
                        } ;
                        while (j < h && i < h && nums[h] == nums[--h]) ;
                    }
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
