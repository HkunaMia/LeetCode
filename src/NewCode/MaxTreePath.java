package NewCode;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ：mzr
 * @date ：Created in 2020/6/2 15:15
 * @description：二叉树中的最大路径和
 * @modified By：
 */
class ReturnType2{
    public int height;
    public int maxDistance;

    public ReturnType2(int height, int maxDistance) {
        this.height = height;
        this.maxDistance = maxDistance;
    }
}


public class MaxTreePath {

    public ReturnType2 search(TreeNode root){
        if(root==null){
            return new ReturnType2(0,0);
        }
        ReturnType2 left = search(root.left);
        ReturnType2 right = search(root.right);
        int height = Math.max(left.height,right.height)+1;
        int maxDistance = Math.max(left.height+right.height+1,Math.max(left.maxDistance,right.maxDistance));

        return new ReturnType2(height,maxDistance);
    }

    public int getMaxDistance(TreeNode root){
        ReturnType2 re = search(root);
        return re.maxDistance;
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

    public static void main(String[] args)  throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
        TreeNode root = bulidTree(in);
        MaxTreePath maxTreePath = new MaxTreePath();
        int res = maxTreePath.getMaxDistance(root);
        System.out.println(res);
    }

}
