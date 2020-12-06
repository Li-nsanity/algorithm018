package Leetcode;
//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C
//的朋友。所谓的朋友圈，是指所有朋友的集合。
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。
//
//
//
// 示例 1：
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
//
//
// 示例 2：
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
//
//
//
//
// 提示：
//
//
// 1 <= N <= 200
// M[i][i] == 1
// M[i][j] == M[j][i]
//
// Related Topics 深度优先搜索 并查集
// 👍 376 👎 0

public class Q547 {
    /**
     * DFS
     *
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        /**
         * 使用一个visited数组，依次判断每个节点。如果其未访问，朋友圈数量加1，
         * 并对该节点进行dfs搜索标记所有访问到的节点。
         */
        boolean[] visited = new boolean[M.length];
        int ret = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                ret++;
            }
        }
        return ret;
    }

    private static void dfs(int[][] m, boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }

    /**
     * 并查集
     * @param M
     * @return
     */
    public static int findCircleNum2(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1)
                    uf.union(i, j);
            }
        }

        return uf.getCount();
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum2(m));
    }
}