package bishi.algorithm.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by asussl on 2016/12/3.
 */
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//}
public class TreeToSequence2 {
    public int[][] convert(TreeNode root) {
        // write code here
        List<Integer> preList = new LinkedList<Integer>();
        List<Integer> midList = new LinkedList<Integer>();
        List<Integer> aftList = new LinkedList<Integer>();
        pre(root, preList);
        mid(root, midList);
        aft(root, aftList);
        int len = preList.size();
        int[][] res = new int[3][];
        res[0] = new int[len];
        res[1] = new int[len];
        res[2] = new int[len];
        listToArray(preList, res[0]);
        listToArray(midList, res[1]);
        listToArray(aftList, res[2]);
        return res;
    }

    public void listToArray(List<Integer> list, int[] res) {
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
    }

    public void pre(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            if (node.right != null) s.push(node.right);
            if (node.left != null) s.push(node.left);
            list.add(node.val);
        }
    }

    public void mid(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode cur = root.left;
        while (!s.isEmpty() || cur != null) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            TreeNode temp = s.pop();
            list.add(temp.val);
            if (temp.right != null) {
                cur = temp.right;
            }
        }
    }

    public void aft(TreeNode root, List<Integer> list) {
        if (root == null) return;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            if (node.left != null) {
                s1.push(node.left);
            }
            if (node.right != null) {
                s1.push(node.right);
            }
            s2.push(node);
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }

    }
//后序遍历：
/*
* 方法一，使用两个栈实现
* 具体过程：1.申请一个站，记为是，然后将头节点压入是中
* 2.从是中弹出的节点记为cur,然后先将做孩子压入s1中,然后把cur的右孩子压入s1中
* 3.在整个过程中，每一个从s1中弹出的节点都放进第二个s2中
* 4.不断重复步骤2和步骤3，知道s1为空，过程停止
* 5.从s2中依次弹出节点并打印，打印的顺序就是后续遍历的顺序了
* 方法二：一个栈
* 1.申请一个栈，记为stack,将头节点压入stack,同时设置两个变量h和c,在
* 整个流程中，h代表最近一次弹出并打印的节点，c代表当前stack的站定节点，初始时令h
* 为头节点，c为null.
* 2.每次令c等于当前stack的站定节点，但是不从stack中弹出节点，此时分为以下三种情况
* （1）如果c的左孩子不为空，并且h不等于c的做孩子，也不等于c的有孩子，则吧c的
* 左孩子压入栈中
* （2）如果情况1不成立，并且c的右孩子不为空，并且h不等于c的右孩子，则吧c的右孩子压入stack中
* （3）如果情况1和情况2都不成立，那么stack中弹出并打印，然后令h等于c
* 3.一直重复步骤2，直到stack为空为止。
* */
}
