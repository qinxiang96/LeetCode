package com.flora.test.dataStructure;

/**
 * @Author qinxiang
 * @Date 2022/11/22-下午5:19
 * 如何求解数组中反序列的个数
 */
public class ArrayTest11 {
    public static void main(String[] args) {
        int a[] = {1,5,3,2,6};
//        System.out.println(reverseCount(a));
        merge_sort(a,0,a.length - 1);
        System.out.println(reverseCount);

    }
    //采用二重遍历的暴力法
    public static int reverseCount(int[] a){
        int count = 0;
        for(int i = 0; i < a.length -1; i ++){
            for(int j = i + 1; j <a.length; j ++){
                if(a[i] > a[j]){
                    count ++;
                }
            }
        }
        return count;
    }
    //分治归并法
    public static int reverseCount = 0;//使用一个计数器来记录逆序对的个数
    public static void merge(int a[], int begin, int mid, int end){
        int i,j,k,n1,n2;
        n1 = mid - begin + 1;
        n2 = end - (mid + 1) + 1;
        int[] l = new int[n1];
        int[] r = new int[n2];
        //对左边的数组进行赋值划分
        for(i = 0, k = begin; i < n1; i ++, k ++){
            l[i] = a[k];
        }
        //对右边的数组进行划分
        for(i = 0, k = mid + 1; i < n2; i ++, k ++){
            r[i] = a[k];
        }
        for(k = begin, i = 0, j = 0; i < n1&& j < n2; k ++){
            //比较左半区域第1个元素和右半区域第1个元素
            if(l[i] < r[j]){
                a[k] = l[i ++];
            }else{
                //如果左边的数比右边的数大，则左边当前的数到中间的数都比右边的数大
                reverseCount += mid - i + 1;
                a[k] = r[j ++];
            }
        }
        //剩余的数直接放进去数组，因为左右2个数组本身就是有序的
        if(i < n1){
            for(j = i; j < n1; j ++, k ++){
                a[k] = l[j];
            }
        }
        if(j < n2){
            for(i = j; i < n2; i ++,k ++){
                a[k] = r[i];
            }
        }
    }
    public static void merge_sort(int[] a, int begin, int end){
        //只有当元素的个数大于1时，才需要进行处理，即begin < end
        if(begin < end){
            int mid = begin + (end - begin)/2;
            //找到中间点，对左边区域和右边区域继续进行划分
            merge_sort(a,begin,mid);
            merge_sort(a,mid + 1,end);
            //划分完，还需要将左半区域和右半区域合并起来
            merge(a,begin,mid,end);
        }
    }
}
