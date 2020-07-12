//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 639 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        //1、两个数组，把非0的复制过去
        //2、在原数组操作，把非0的弄到前面去
/*        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }*/
        //3、把0跟非0的数交换
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0){
                int sum = nums[i];
                nums[i] = nums[j];
                nums[j] = sum;
                i++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
