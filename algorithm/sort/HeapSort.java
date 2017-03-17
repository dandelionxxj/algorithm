package bishi.algorithm.sort;

/**
 * Created by asussl on 2017/2/1.
 */
public class HeapSort {
    public static void main(String[] args){
//        测试用例:
//        [32,103,24,88,95,70,97,15,102,6,79,46,51,37,93,108,9,58,53,58,79,36,58,91,78,58,61,81],28
//
//        对应输出应该为:
//
//        [6,9,15,24,32,36,37,46,51,53,58,58,58,58,61,70,78,79,79,81,88,91,93,95,97,102,103,108]
//
//        你的输出为:
//        [6,9,15,24,   36,37,46,51,53,58,58,58,58,61,70,78,79,79,81,88,91,93,95,  102,97,103,108,32]
        int[] A={32,103,24,88,95,70,97,15,102,6,79,46,51,37,93,108,9,58,53,58,79,36,58,91,78,58,61,81};
        int[] result=heapSort(A,28);
        printArr(result);
    }
    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] heapSort(int[] A, int n) {
        // write code here
        //1.判断输入
        if(A==null||A.length==0){
            return null;
        }
        //2.建堆：就是传过来的数组，并调整，
        for(int start=A.length/2;start>0;start--){
            heapAdjust(A,start,A.length-1);
//            printArr(A);
//            System.out.println("-----------");
        }
        //3.逐个弹出大顶堆，并调整
        for(int end=A.length-1;end>0;end--){
            swap(A,0,end);
            heapAdjust(A,0,end-1);
//            printArr(A);
        }
        //4.返回结果，数组对象
        return A;
    }
    public static void heapAdjust(int[] arr, int start, int end){
        //暂存开始元素
        int temp=arr[start];
        //有无子元素
        for(int i=start*2+1;i<=end;i*=2){
            //左孩子arr[2*i+1],右孩子arr[2*i+2]
            if(i < end && arr[i] < arr[i+1]) {
                i ++;
            }
            //判断是否符合大顶堆
            if(temp>=arr[i]){
                break;//已是大顶堆
            }
            arr[start]=arr[i];
            start=i;//设置下一轮初始值
        }
        arr[start]=temp;
    }

    public static void swap(int[] arr, int m, int n){
        int temp=arr[m];
        arr[m]=arr[n];
        arr[n]=temp;
    }
}
