package DataStructure;

public class BinarySearchTree {

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node tree;


//    查找
    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) p = p.left;
            else if (data > p.data) p = p.right;
            else return p;
        }
        return null;
    }


    //插入
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

//  删除节点
    public void delete(int data) {

        Node delete = tree; // p指向要删除的节点，初始化指向根节点
        Node parent = null; // pp记录的是p的父节点
        while (delete != null && delete.data != data) {
            parent = delete;
            if (data > delete.data) delete = delete.right;
            else delete = delete.left;
        }
        if (delete == null) return; // 没有找到

        // 要删除的节点有两个子节点
        if (delete.left != null && delete.right != null) {
            // 查找右子树中最小节点
            Node minP = delete.right;
            Node minParent = delete; // minPP表示minP的父节点
            while (minP.left != null) {
                minParent = minP;
                minP = minP.left;
            }
            delete.data = minP.data; // 将minP的数据替换到p中
            delete = minP; // 下面就变成了删除minP了
            parent = minParent;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (delete.left != null) child = delete.left;
        else if (delete.right != null) child = delete.right;
        else child = null;

        if (parent == null) tree = child; // 删除的是根节点
        else if (parent.left == delete) parent.left = child;
        else parent.right = child;
    }


}



