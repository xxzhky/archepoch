package com.gp.vip.interview.test.seqops;

import java.util.TreeMap;

public class ComputeSeqLens {
    public static void main(String[] args) {
        String str1 = "hellowdhelloko";
        str1="hgaoooab";
        //max_unique_substring3(str1);
        max_unique(str1);
    }

    //O(N^2)的时间复杂度
    static void max_unique(String str) {
        // begin用来保存 最长不重复子串的 开始索引
        int begin = 0;
        // maxlen用来保存最长不重复子串的 长度
        int maxlen = 0;
        // 定义一个容器，用来保存遍历时候遇到的每一个字符的出现次数情况
        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
        int n = str.length();

        int j = 0;
        for (int i = 0; i < n; ++i) {
            // 初始化   hash 这个数组，用0补充
            for (int k = 0; k < n; k++) {
                tm.put(str.charAt(k), 0);
            }
            tm.put(str.charAt(i), 1);
            // 往i+1开始往后找，遇到和i索引处不一样的元素，就将那个位置的“键值”置1；
            // 遇到一样的就 break，让j停在现在这个位置
            for (j = i + 1; j < n; ++j) {
                if (tm.get(str.charAt(j)) == 0)
                    tm.put(str.charAt(j), 1);
                else
                    break;
            }
            // 上面j刚好停在了，第一次出现重复的那个位置，相减即为这个时候的最长子串长度，
            // i索引是其的开始
            if (j - i > maxlen) {
                maxlen = j - i;
                begin = i;
            }
            System.out.println(tm);
        }
        System.out.println(maxlen + " " + str.substring(begin, begin + maxlen));

    }

    //O(N)的时间复杂度
    static void max_unique_substring3(String str) {
        int maxlen = 0;
        int begin = 0;
        int n = str.length();
        int[] next = new int[n]; //next[i]记录了下一个与str[i]重复的字符的位置
        int[] first = new int[n + 1]; //first[i]记录str[i]后面最近的一个重复点

        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();
        // 初始化   tm 这个数组，用0补充
        for (int k = 0; k < n; k++) {
            tm.put(str.charAt(k), n);
        }

        System.out.println(tm);
        first[n] = n;
        for (int i = n - 1; i >= 0; i--) {
            // next[i]记录了下一个与str[i]重复的字符的位置    first[i]记录str[i]后面最近的一个重复点
            // tm中存放的就是  下一个与str[i]重复的字符的位置 ，
            next[i] = tm.get(str.charAt(i));
            // 在这会进行 更新 tm
            tm.put(str.charAt(i), i);
            // 如果next存放的这个 索引 小于 str[i]后面最近的 1 个重复点。如果无，就是 n 这个数字
            if (next[i] < first[i + 1])
                first[i] = next[i];
            else
                first[i] = first[i + 1]; //生成first[]表，复杂度是O(N)的
        }
        System.out.println(tm);
        for (int i = 0; i < n; i++) {
            if (first[i] - i > maxlen) {
                maxlen = first[i] - i;
                begin = i;
            }
        }
        System.out.println(maxlen + " " + str.substring(begin, begin + maxlen));
    }


}
