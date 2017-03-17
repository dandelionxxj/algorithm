package bishi.algorithm.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by asussl on 2016/12/3.
 */
public class TreeToSequence1 {
    public int[][] convert(TreeNode root) {
        // write code here
        List<Integer> preList=new LinkedList<Integer>();
        List<Integer> midList=new LinkedList<Integer>();
        List<Integer> aftList=new LinkedList<Integer>();
        pre(root,preList);
        mid(root,midList);
        aft(root,aftList);
        int len=preList.size();
        int[][] res=new int[3][];
        res[0]=new int[len];
        res[1]=new int[len];
        res[2]=new int[len];
        listToArray(preList,res[0]);
        listToArray(midList,res[1]);
        listToArray(aftList,res[2]);
        return res;

    }
    public void listToArray(List<Integer> list,int [] res){
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
    }
    public void pre(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if(root.left!=null) pre(root.left,list);
        if(root.right!=null) pre(root.right,list);

    }
    public void mid(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left!=null) mid(root.left,list);
        list.add(root.val);
        if(root.right!=null) mid(root.right,list);
    }
    public void aft(TreeNode root,List<Integer> list){
        if(root==null) return;
        if(root.left!=null) aft(root.left,list);
        if(root.right!=null) aft(root.right,list);
        list.add(root.val);

    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}