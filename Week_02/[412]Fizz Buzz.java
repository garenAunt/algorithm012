//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 65 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
/*        List<String> ans = new ArrayList<>();

        HashMap<Integer, String> fizzBuzzDict = new HashMap<>() {{
            put(3, "Fizz");
            put(5, "Buzz");
        }};
        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key : fizzBuzzDict.keySet()
            ) {
                if (num % key == 0) {
                    numAnsStr += fizzBuzzDict.get(key);
                }
            }
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }
            ans.add(numAnsStr);
        }
        return ans;*/
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 ==0 && i % 5 == 0){
                res.add("FizzBuzz");
            }else if (i % 3 == 0){
                res.add("Fizz");
            }else if (i % 5 == 0){
                res.add("Buzz");
            }else {
                res.add(Integer.toString(i));
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
