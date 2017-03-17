package bishi.algorithm.binarySearch;

/**
 * Created by asussl on 2016/11/23.
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class CountNodes {
    public int count(TreeNode root) {
        // write code here
        if(root==null) return 0;
        int left=TreeDeep(root.left);
        int right=TreeDeep(root.right);
        if(left==right) return count(root.right)+(int)Math.pow(2,left);
        return count(root.left)+(int)Math.pow(2,right);
    }
//    public int TreeDeep(TreeNode root){
//        if(root==null) return 0;
//        int left=TreeDeep(root.left);
//        int right=TreeDeep(root.right);
//        return left>=right?left+1:right+1;
//    }
    public int TreeDeep(TreeNode root) {
        int n = 1;
        while(root != null) {
            root = root.left;
            n++;
        }
        return n;
    }
}
