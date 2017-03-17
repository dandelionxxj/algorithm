package bishi.algorithm.Tree;

/**
 * Created by asussl on 2016/12/4.
 */
public class TreeToSerialize {
    public String toString(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Serialize(root, builder);
        return builder.toString();
    }
    private void Serialize(TreeNode root, StringBuilder builder)
    {
        if(root == null)
            builder.append("#!");
        else
        {
            builder.append(root.val).append("!");
            Serialize(root.left, builder);
            Serialize(root.right, builder);
        }
    }
}
