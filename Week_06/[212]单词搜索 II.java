//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 216 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//改造前缀树节点
class TrieNode {
    public TrieNode[] children;
    public String word; //节点直接存当前的单词

    public TrieNode() {
        children = new TrieNode[26];
        word = null;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] array = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < array.length; i++) {
            // 当前孩子是否存在
            if (cur.children[array[i] - 'a'] == null) {
                cur.children[array[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[array[i] - 'a'];
        }
        // 当前节点结束，存入当前单词
        cur.word = word;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        //将所有单词存入前缀树中
        List<String> res = new ArrayList<>();
        for (String word : words) {
            trie.insert(word);
        }
        int rows = board.length;
        if (rows == 0) {
            return res;
        }
        int cols = board[0].length;
        //从每个位置开始遍历
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                existRecursive(board, i, j, trie.root, res);
            }
        }
        return res;
    }

    private void existRecursive(char[][] board, int row, int col, TrieNode node, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        char cur = board[row][col];//将要遍历的字母
        //当前节点遍历过或者将要遍历的字母在前缀树中不存在
        if (cur == '$' || node.children[cur - 'a'] == null) {
            return;
        }
        node = node.children[cur - 'a'];
        //判断当前节点是否是一个单词的结束
        if (node.word != null) {
            //加入到结果中
            res.add(node.word);
            //将当前单词置为 null，防止重复加入
            node.word = null;
        }
        char temp = board[row][col];
        //上下左右去遍历
        board[row][col] = '$';
        existRecursive(board, row - 1, col, node, res);
        existRecursive(board, row + 1, col, node, res);
        existRecursive(board, row, col - 1, node, res);
        existRecursive(board, row, col + 1, node, res);
        board[row][col] = temp;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
