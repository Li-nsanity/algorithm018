package Leetcode;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
//输出: false
//
// 说明:
//你可以假设字符串只包含小写字母。
//
// 进阶:
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 👍 267 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str1.length; i++) {
            if (map.containsKey(str1[i])) {
                map.put(str1[i], map.get(str1[i]) + 1);
            } else {
                map.put(str1[i], 1);
            }
        }
        for (int i = 0; i < str2.length; i++) {
            if (map.containsKey(str2[i]) && map.get(str2[i]) > 0) {
                map.put(str2[i], map.get(str2[i]) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(isAnagram3(str1, str2));
        System.out.println(str1.charAt(1));
    }
}
