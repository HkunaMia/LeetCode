package NewCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/2 11:37
 * @description：找到二叉书中最大的二叉搜索树
 * @modified By：
 */

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (int data) {
        this.val = data;
    }
}

class ReturnType{
    public TreeNode node;
    public int maxSize;
    public int max;
    public int min;

    public ReturnType(TreeNode node, int maxSize, int max, int min) {
        this.node = node;
        this.maxSize = maxSize;
        this.max = max;
        this.min = min;
    }
}

public class BigBinaryTree {

    public ReturnType process(TreeNode X){
//        何时返回
        if(X == null){
            return new ReturnType(null,0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
//        左子树与右子树
        ReturnType left = process(X.left);
        ReturnType right = process(X.right);

//        整合所有信息
//        得到以X为头结点的子树的return信息
        int min = Math.min(X.val,Math.min(left.min,right.min));
        int max = Math.max(X.val,Math.max(left.max,right.max));
        int maxSize = Math.max(left.maxSize,right.maxSize);
        TreeNode maxBTSNode = left.maxSize >= right.maxSize ? left.node : right.node;

//        判断是否可以加上X节点
        if(left.node == X.left && right.node ==X.right
                && left.max < X.val && X.val< right.min){
            maxSize = left.maxSize + right.maxSize+1;
            maxBTSNode = X;
        }
        return new ReturnType(maxBTSNode,maxSize,max,min);
    }

    public int getMaxBts(TreeNode root){
        return process(root).maxSize;
    }

    public static TreeNode bulidTree(BufferedReader in) throws IOException {
        String[] s = in.readLine().split(" ");
        int[] nodes = new int[s.length];

        for(int j = 0; j < nodes.length; j++) {
            nodes[j] = Integer.parseInt(s[j]);
        }

        TreeNode node = new TreeNode(nodes[0]);
        if(nodes[1] != 0){
            node.left = bulidTree(in);
        }
        if(nodes[2] != 0){
            node.right = bulidTree(in);
        }
        return node;
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        TreeNode root = bulidTree(in);
        BigBinaryTree bigBinaryTree = new BigBinaryTree();
        int res = bigBinaryTree.getMaxBts(root);
        System.out.println(res);
    }
}
