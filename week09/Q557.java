package Leetcode;
//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 字符串
// 👍 260 👎 0

public class Q557 {
    /**
     * JAVA中String是immutable的，原地算法不适合
     * O(n)
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] sentence = s.toCharArray();
        int i = 0, j = 0;
        while (j < sentence.length) {
            while (i < sentence.length && sentence[i] == ' ') ++i;
            while (j < sentence.length && sentence[j] != ' ') ++j;
            reverse(sentence, i, j - 1);
            i = j;
            ++j;
        }
        s = String.valueOf(sentence);
        return s;
    }

    private static void reverse(char[] arr, int start, int end) {
        if (arr.length == 0) return;
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
