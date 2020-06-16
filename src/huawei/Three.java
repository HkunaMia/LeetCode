//package huawei;
//
//import java.util.Scanner;
//
//class TreeNode{
//    private int val;
//    private TreeNode left;
//    private TreeNode right;
//
//}
//
//public class Three {
//    int ans = Integer.MIN_VALUE;
//
//    public int maxPathSum(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        dfs(root);
//        return ans;
//    }
//
//    public int dfs(TreeNode root){
//        if(root==null) return 0;
//        int temp = Math.max(dfs(root.left),dfs(root.right));
//        if(temp>0){
//            temp += root.val;
//        }else{
//            temp = root.val;
//        }
//        int val = root.val;
//        if(dfs(root.left)>=0) val += dfs(root.left);
//        if(dfs(root.right >=0)) val += dfs(root.right);
//        ans = Math.max(ans,val);
//        return temp;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//    }
//}
