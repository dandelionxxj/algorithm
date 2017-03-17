package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/17.
 */
//如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有
//        "12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
//        给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
//        测试样例：
//        "cdab",4,"abcd",4
//        返回：true
public class chkRotation {
}
 class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if(A==null||B==null||lena<0||lenb<0||lena!=lenb) return false;
        String C=A+A;
        return getIndexOf(C,B)!=-1;
    }
    public int getIndexOf(String s,String m){
        if(s==null||m==null||s.length()<0|m.length()<0||s.length()<m.length()) return -1;
        char[] ss=s.toCharArray();
        char[] ms=m.toCharArray();
        int [] nextArr=getNextArray(ms);
        int lens=ss.length;
        int lenm=ms.length;
        int index=0;
        int mi=0;
        while(index<lens&&mi<lenm){
            if(ss[index]==ms[mi]){
                index++;
                mi++;
            }else if(nextArr[mi]==-1){
                index++;
            }else{
                mi=nextArr[mi];
            }
        }
        return mi==lenm?index-mi:-1;

    }
    public int[]getNextArray(char[] ms){
        int len=ms.length;
        if(len==1) {
            return new int[]{-1};
        }
        int nextArr[]=new int[len];
        nextArr[0]=-1;
        nextArr[1]=0;
        int ch=0;
        int pos=2;
        while(pos<len){
            if(ms[pos-1]==ms[ch]){
                nextArr[pos++]=ch++;
            }else if(ch>0){
                ch=nextArr[ch];
            }else{
                nextArr[pos++]=0;
            }
        }
        return nextArr;
    }
}