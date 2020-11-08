package Leetcode;
//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 743 👎 0

import java.util.HashMap;

public class Q105 {
    /**
     * 利用递归，利用hashmap存储inorder中的数组下标，key是node.val，value是数组下标，不断地把问题的规模缩小
     * 前序中序遍历 画出二叉树会，第一次完成这个代码，还有些不熟练
     * 时间复杂度O(n)，循环放入map是O(n)，递归每一个node也是O(n)，所以时间复杂度应该是O(n)
     * 空间复杂度借用了hashmap,所以也应该是O(n)级别
     * 请您订正
     * 谢谢！
     */
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, HashMap<Integer, Integer> map) {
        if (pstart == pend) {
            return null;
        }
        int rootval = preorder[pstart];
        TreeNode root = new TreeNode(rootval);
        int inoderindex = this.map.get(rootval);
        int leftNum = inoderindex - istart;
        root.left = buildTreeHelper(preorder, pstart + 1, pstart + leftNum + 1, inorder, istart, inoderindex, map);
        root.right = buildTreeHelper(preorder, pstart + leftNum + 1, pend, inorder, inoderindex + 1, iend, map);
        return root;
    }
}
