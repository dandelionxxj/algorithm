package bishi.algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by asussl on 2016/12/4.
 */
public class TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        if(root==null) throw new RuntimeException("error");
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        printTreeCore(root,res);
        int[][] result=new int[res.size()][];
        listToArray(res,result);
        return result;
    }
    public void listToArray(ArrayList<ArrayList<Integer>> list, int[][] res) {

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> temp=list.get(i);
            res[i]=new int[temp.size()];
            for(int j=0;j<temp.size();j++){
                res[i][j]=temp.get(j);
            }
        }
    }
    public void printTreeCore(TreeNode root,ArrayList<ArrayList<Integer>> list){
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        ArrayList<Integer> line=new ArrayList<Integer>();
        TreeNode last,nlast;
        queue.add(root);
        nlast=last=root;
        while(!queue.isEmpty()){
            TreeNode temp=queue.poll();
            line.add(temp.val);
            if(temp.left!=null){
                queue.add(temp.left);
                nlast=temp.left;
            }
            if(temp.right!=null){
                queue.add(temp.right);
                nlast=temp.right;
            }
            if(last==temp){
                list.add(line);
                line=new ArrayList<Integer>();
                last=nlast;
            }

        }

    }
}
