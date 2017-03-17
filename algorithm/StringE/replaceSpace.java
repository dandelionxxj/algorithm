package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/17.
 */
public class replaceSpace {
}
class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        if(iniString==null||length<0){
            return "";
        }
        int count=0;
        int len=iniString.length();
        for(int i=0;i<len;i++){
            if(iniString.charAt(i)==' ') count++;
        }
        int newLength=len+2*count;//注意是乘以2；
        char[] arr=new char[newLength];
        for(int i=len-1,j=newLength-1;i>=0;i--){
            if(iniString.charAt(i)==' '){
                arr[j--]='0';
                arr[j--]='2';
                arr[j--]='%';
            }else{
                arr[j--]=iniString.charAt(i);
            }
        }
        return String.valueOf(arr);
    }
}