package Leetcode;
//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。
//
// 注意:
//
//
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
// 所有的目标基因序列必须是合法的。
// 假定起始基因序列与目标基因序列是不一样的。
//
//
// 示例 1:
//
//
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
//
//
// 示例 2:
//
//
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
//
//
// 示例 3:
//
//
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
//
// 👍 60 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q433 {
    public int minMutation(String start, String end, String[] bank) {
        char[][] banks = new char[bank.length][8];
        for (int i = 0; i < bank.length; i++) {
            banks[i] = bank[i].toCharArray();
        }
        solution1(start.toCharArray(), end.toCharArray(), banks, 0);
        return minChange == Integer.MAX_VALUE ? -1 : minChange;
    }

    int minChange = Integer.MAX_VALUE;

    // 执行耗时:0 ms,击败了100.00% 的Java用户
    // 内存消耗:37.1 MB,击败了98.97% 的Java用户
    private void solution1(char[] start, char[] end, char[][] bank, int change) {
        if (Arrays.equals(start, end)) {
            minChange = Math.min(minChange, change);
            return;
        }

        for (int j = 0; j < bank.length; j++) {
            char[] piece = bank[j];
            if (piece == null) continue; // 已用过的片段
            int diff = 0; // 获取基因库中不同为1的片段,作为改变一次后的新start
            for (int i = 0; i < start.length; i++) {
                if (start[i] != piece[i]) diff++;
            }
            if (diff == 1) {
                bank[j] = null; // 置空,防止循环使用
                solution1(piece, end, bank, change + 1);
                bank[j] = piece; // 还原回溯
            }
        }
    }

    /**
     * 双向BFS
     *
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation2(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String word : bank) {
            bankSet.add(word);
        }

        if (!bankSet.contains(end)) {
            return -1;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);

        int len = 0;
        Set<String> visit = new HashSet<>();

        char[] bankChar = new char[]{'A', 'C', 'G', 'T'};

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> tmp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        char old = chs[i];
                        chs[i] = bankChar[j];
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visit.contains(target) && bankSet.contains(target)) {
                            visit.add(target);
                            tmp.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = tmp;
            len++;
        }
        return -1;
    }
}
