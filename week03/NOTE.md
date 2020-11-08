# 学习笔记
## 第三周总结
### 1.递归
1.递归代码模板  
```
public void recur(int level,int param){  
	
	//terminator 递归终止条件
	if(level > MAX_LEVEL){
		//process result
		return;
	}
	//process current logic 处理当前层逻辑
	process(level,param);
	//drill down 下探到下一层
	recur(level:level+1,newParam);
	//restore current status 清理当前层
}
```  

2.分治模板  
  
```
public void recur(int level,int param){  
	
	//terminator 递归终止条件
	if(level > MAX_LEVEL){
		//process result
		return;
	}
	//process(split your big problems) 分解当前大问题
	//drill down(subproblems) 调用函数去做子问题
	merge(subresults);
	//reverse status
}
```  
### 二叉树专题
题目：1.翻转二叉树  2.验证二叉搜索树 3.二叉树的最大深度 4.二叉树的最小深度 5.二叉树的序列化与反序列化  
总结：1.广度优先搜索->中序遍历 升序  
  	 2.BFS是解决树问题的一个有力武器  
模板：
  
```  

class Solution {  
	public TreeNode invertTree(TreeNode root) {

		if(root==null) {
			return null;
		}

		//将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			//每次都从队列中拿一个节点做处理
			
			//如果当前节点的左子树不为空，则放入队列等待后续处理
			if(tmp.left!=null) {
				queue.add(tmp.left);
			}
			//如果当前节点的右子树不为空，则放入队列等待后续处理
			if(tmp.right!=null) {
				queue.add(tmp.right);
			}
		}
		//返回处理完的根节点
		return root;
	}
}
```  
    3.回溯模板  
```   

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;

                System.out.println("  递归之前 => " + path);
                dfs(nums, len, depth + 1, path, used, res);

                used[i] = false;
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }
        }
    }
 
```    
总结：排序是剪枝的前提
剪枝模板语句：
`  
if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
    continue;
}  
`  


