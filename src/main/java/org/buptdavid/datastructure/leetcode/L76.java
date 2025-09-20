package org.buptdavid.datastructure.leetcode;

/**
 * @author stan
 * @date 2025/2/17
 */
public class L76 {


    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC", result = "BANC";
        String r = new Solution().minWindow(s, t);
        System.out.println(r);
        System.out.println(r.equals(result));
    }

    static class Solution {
        public String minWindow(String s, String t) {
            // 遍历当前字符串
            int start = 0, end = 0;
            String result = "", bestResult = "";
            while (end < s.length()) {
                result = s.substring(start, end + 1);
                while (checkStr(result, t)) {
                    System.out.println("abc");
                    System.out.format("hit: %s, %s%n", result, t);
                    if (bestResult.isEmpty()) {
                        bestResult = result;
                    } else {
                        bestResult = bestResult.length() < result.length() ? bestResult : result;
                    }
                    start++;
                    result = result.substring(start);
                }
                end++;
            }
            return bestResult;
        }

        private boolean checkStr(String sub, String t) {
            if (sub.length() < t.length()) {
                return false;
            }
            for (int i = 0; i < t.length(); i++) {
                int c = t.indexOf(i);
                if (!sub.contains(c + "")) {
                    return false;
                }
            }
            return true;
        }

    }

}
