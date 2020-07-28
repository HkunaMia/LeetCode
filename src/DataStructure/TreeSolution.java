package DataStructure;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/22
 * \* Time: 10:29
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 树的相关操作
 * \
 */

public class TreeSolution {

//    数组的树化
//    输入数组形式[1,2,3,4,5,6,7]
    public TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }


    public List<Integer> preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            arrayList.add(node.data);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null ){
                stack.push(node.left);
            }
        }
        return arrayList;
    }

    public ArrayList inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(root !=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.pop();
            arrayList.add(node.data);
            root = node.right;
        }
        return arrayList;
    }

    public ArrayList lastOrder(TreeNode root){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);
            if(node.left!=null){
                stack1.push(node.left);
            }
            if(node.right!=null){
                stack1.push((node.right));
            }
        }
        while (!stack2.isEmpty()){
            arrayList.add(stack2.pop().data);
        }
        return arrayList;
    }

    public ArrayList bfs(TreeNode root){
        ArrayList arrayList = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            arrayList.add(node.data);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        TreeSolution solution = new TreeSolution();
        TreeNode root = solution.stringToTreeNode(line);
        List<Integer> integers = solution.preOrder(root);
        ArrayList arrayList1 = solution.inOrder(root);
        ArrayList arrayList2 = solution.lastOrder(root);
        ArrayList arrayList3 = solution.bfs(root);
        System.out.println(integers.toString());
        System.out.println(arrayList1.toString());
        System.out.println(arrayList2.toString());
        System.out.println(arrayList3.toString());
    }
}
