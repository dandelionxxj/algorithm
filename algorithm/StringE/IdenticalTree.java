package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/15.
 * 拓扑结构相同的子树
 */
public class IdenticalTree {
    public static void main(String[] args){
        String s="";

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
class IdenticalTree1 {
    public class IdenticalTree {
        public boolean chkIdentical(TreeNode A, TreeNode B) {
            // write code here
            String str1 = serialByTree(A);
            String str2 = serialByTree(B);
            return getIndexOf(str1, str2) != -1;

        }

        public String serialByTree(TreeNode node) {
            if (node == null) return "#!";
            String result = node.val + "!";
            result = result + serialByTree(node.left) + serialByTree(node.right);
            return result;
        }
        // KMP
        public int getIndexOf1(String s, String m) {
            if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
                return -1;
            }
            char[] ss = s.toCharArray();
            char[] ms = m.toCharArray();
            int[] next = getNextArray(ms);
            int index = 0;
            int pos = 0;
            while (index < ss.length && pos < ms.length) {
                if (ss[index] == ms[pos]) {
                    index++;
                    pos++;
                } else if (next[pos] == -1) {
                    index++;
                } else {
                    pos = next[pos];
                }
            }
            return pos == ms.length ? index - pos : -1;
        }
        //kmp;
        public int getIndexOf(String s, String m) {
            if (s == null || m == null || m.length() < 1 || s.length() < m.length())
                return -1;
            char[] ss = s.toCharArray();
            char[] ms = m.toCharArray();
            int[] next = getNextArray(ms);
            int lens = ss.length;
            int lenm = ms.length;
            int index = 0;
            int pos = 0;
            while (index < lens && pos < lenm) {
                if (ss[index] == ms[pos]) {
                    index++;
                    pos++;
                } else if (next[pos] == -1) {//注意细节，忘记else,错写成if,应为else if
                    index++;
                } else {
                    pos = next[pos];
                }
            }
            return pos == lenm ? index - lenm : -1;




        }

        public int[] getNextArray(char[] ms) {
            if (ms.length == 1) {
                return new int[]{-1};
            }
            int len = ms.length;
            int[] next = new int[len];
            next[0] = -1;
            next[1] = 0;
            int ch = 0;
            int pos = 2;
            while (pos < len) {
                if (ms[pos - 1] == ms[ch]) {
                    next[pos++] = ch++;
                } else if (ch > 0) {
                    //不等就往前跳
                    ch = next[ch];
                } else {
                    next[pos++] = 0;
                }
            }
            return next;
        }
    }
}