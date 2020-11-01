package Leetcode;
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例:
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//
// 说明：
//
//
// 所有输入均为小写字母。
// 不考虑答案输出的顺序。
//
// Related Topics 哈希表 字符串
// 👍 503 👎 0

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String find = new String(s);
            if (map.containsKey(find)) {
                List<String> arr = map.get(find);
                arr.add(str);
                map.put(find, arr);
            } else {
                List<String> arr = new LinkedList<>();
                arr.add(str);
                map.put(find, arr);
            }
        }
        return new ArrayList<>(map.values());
    }
}
