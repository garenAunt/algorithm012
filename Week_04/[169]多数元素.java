//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 682 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
/**
 * 排序思路
 *既然数组中有出现次数> ⌊ n/2 ⌋的元素，那排好序之后的数组中，相同元素总是相邻的。
 *即存在长度> ⌊ n/2 ⌋的一长串 由相同元素构成的连续子数组。
 *举个例子：
 *无论是1 1 1 2 3，0 1 1 1 2还是-1 0 1 1 1，数组中间的元素总是“多数元素”，毕竟它长度> ⌊ n/2 ⌋。*/
        Arrays.sort(nums);
        return nums[nums.length >> 1];
/**
 * 摩尔投票法思路
 *候选人(cand_num)初始化为nums[0]，票数count初始化为1。
 *当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
 *当票数count为0时，更换候选人，并将票数count重置为1。
 *遍历完数组后，cand_num即为最终答案。
 *为何这行得通呢？
 *投票法是遇到相同的则票数 + 1，遇到不同的则票数 - 1。
 *且“多数元素”的个数> ⌊ n/2 ⌋，其余元素的个数总和<= ⌊ n/2 ⌋。
 *因此“多数元素”的个数 - 其余元素的个数总和 的结果 肯定 >= 1。
 *这就相当于每个“多数元素”和其他元素 两两相互抵消，抵消到最后肯定还剩余至少1个“多数元素”。
 *无论数组是1 2 1 2 1，亦或是1 2 2 1 1，总能得到正确的候选人。*/
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i]) {
                count++;
            } else if (count-- == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
