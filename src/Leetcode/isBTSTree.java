package Leetcode;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/30
 * \* Time: 11:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:验证一棵树是否是二叉搜索树
 * \
 */

public class isBTSTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    long pre = Long.MIN_VALUE;

//    二叉搜索树的中序遍历是从小到大有序的
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(!isValidBST(root.left)){
            return false;
        }
        if(pre>=root.val){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }


}
