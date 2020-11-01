package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//给定一个二叉树，返回它的 后序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [3,2,1]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 470 👎 0
public class Q145 {
    /**
     * 儍递归
     * 时间复杂度O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    /**
     * 迭代利用栈
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = stack.peek();
                //是否变到右子树
                if (temp.right != null && temp.right != last) {
                    cur = temp.right;
                } else {
                    list.add(temp.val);
                    last = temp;
                    stack.pop();
                }
            }
        }
        return list;
    }

    /**
     * 迭代利用栈（巧用前序遍历翻转）
     * 时间复杂度：O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.right; // 考虑左子树
            } else {
                // 节点为空，就出栈
                cur = stack.pop();
                // 考虑右子树
                cur = cur.left;
            }
        }
        Collections.reverse(list);
        return list;
    }
}
