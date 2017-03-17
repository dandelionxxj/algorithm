package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/17.
 */
public class reverseSentence {

    public static void main(String[] args){

    }
}
class Reverse {
    public String reverseSentence(String A, int n) {
        // write code here
        if(A==null||n<0){
            return A;
        }
        char[]arr=A.toCharArray();
        rotateWord(arr);
        return String.valueOf(arr);
    }
    public void rotateWord(char[] chars){
        if(chars==null||chars.length==0) return;
        reverse(chars,0,chars.length-1);
        int l=-1;
        int r=-1;
        for(int i=0,len=chars.length;i<len;i++){
            l=i==0||chars[i-1]==' '?i:l;
            if(l!=-1&&r!=-1){
                reverse(chars,l,r);
                l=-1;
                r=-1;
            }
        }
    }
    public void reverse(char[] ss,int start,int end){
        char temp=0;
        while(start<end){
            temp=ss[end];
            ss[end]=ss[start];
            ss[start]=temp;
            start++;
            end--;
        }
    }
}