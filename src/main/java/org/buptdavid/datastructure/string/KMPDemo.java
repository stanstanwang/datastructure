package org.buptdavid.datastructure.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author stan
 * @date 2025/4/25
 */
public class KMPDemo {


    @Test
    public void test() {
        String str = "abc";
        // String pattern = "abcabdabdabc";
        String pattern = "ABABABAC";

        int[] pi = pi(pattern);
        System.out.println(Arrays.toString(pi));
    }


    // abcab dabc
    // 00012 0


    // ABABA C
    // 00123 2


    // abcabcefg abcabcefgd abcabcefg abcabcefgf


    public int[] pi(String str) {
        int[] pi = new int[str.length()];
        for (int i = 1; i < pi.length; i++) {
            int len = pi[i - 1];


            // 利用删一次匹配的前缀来方便算出下一次的前缀
            // 可以将前缀理解为要找的子串
            // 如果匹配，那么其实长度+1
            // 如果不匹配，找上一次匹配到的最大长度，就是子串的子串，尽量减少匹配的逻辑

            // 关键回退逻辑：当字符不匹配时，利用已计算的pi值进行回溯
            while (len != 0 && str.charAt(len) != str.charAt(i)) {
                len = pi[len - 1]; // // 回退到前一个匹配位置的长度
                System.out.printf("i=%s,len1=%s,len2=%s%n",i, pi[i-1],len);
            }
            //如果下一位长度还相等，那么长度+1
            if (str.charAt(len) == str.charAt(i)) {
                pi[i] = len + 1;
            }
        }
        return pi;
    }


}
