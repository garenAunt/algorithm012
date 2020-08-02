//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1197 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Node {
        private String res;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) res.add(curNode.res);
            if (curNode.left > 0) queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            if (curNode.right > 0 && curNode.left < curNode.right)
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
