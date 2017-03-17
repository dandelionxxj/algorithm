package bishi.algorithm.sort;

/**
 * Created by asussl on 2017/1/31.
 * //基数排序
 */
public class RadixSort {
    public static void main(String[] args)
    {
        int[]data =
                {54,35,48,36,27,12,44,44,8,14,26,17,28};
        RadixSort.radixSort(data, data.length);
        for(int i = 0; i < data.length; i++)
        {
            System.out.print(data[i] + " ");
        }
    }
    public static int[] radixSort(int[] A, int n) {
        // write code here
        int d=4;///d表示最大的数有多少
        int k=0;//输出指针
        int m=1;//指向位数
        int a=1;//表示除数
        int len=A.length;
        int numbers[][]=new int[10][n];//高维表示0-9个桶，低维表示每个关键字各个位上的余数,每个桶内可能有n个值
        int count[]=new int[10];//用来表示该位是i的数的个数
        while(m<=d){
            //处理
            //装桶
            for(int i=0;i<len;i++){
                int lsd=(A[i]/a)%10;
                numbers[lsd][count[lsd]]=A[i];
                count[lsd]++;
            }
            //倒桶
            for(int i=0;i<10;i++){
                if(count[i]!=0){
                    for(int j=0;j<count[i];j++){
                        A[k++]=numbers[i][j];
                    }
                }
                //清零
                count[i]=0;
            }
            k=0;
            a*=10;
            m++;
        }
        return A;
    }
}
