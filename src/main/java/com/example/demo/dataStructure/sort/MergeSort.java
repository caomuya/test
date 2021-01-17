package com.example.demo.dataStructure.sort;

import javax.sound.midi.Soundbank;
import java.time.temporal.Temporal;

/**
 * 归并排序 O(nlogn)
 * @author caomuya
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,4,6,0,2,7,3,8};
        mergeSort(a,a.length);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+"->");
        }

    }

    public static void mergeSort(int[]  a ,int n){
        mergeSortInternally(a,0,n-1);

    }

    private static void mergeSortInternally(int[]  a ,int p,int r){
        //递归终止条件
        if(p >= r) {
            return;
        }
        int q = p+(r-p)/2;

        mergeSortInternally(a,p,q);
        mergeSortInternally(a,q+1,r);

//        merge(a,p,q,r);
        mergeBySentry(a,p,q,r);
    }

    private static void merge(int[] a,int p, int q, int r){
        int i = p;
        int j = q+1;
        int k = 0;
        int[] tmp = new int[r-p+1];
        while (i<=q && j<=r){
            if(a[i] <= a[j]){
                tmp[k++] = a[i++];
            }else{
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组有剩余数据
        int start = i;
        int end = q;
        if(j<=r){
            start = j;
            end = r;
        }
        while(start<=end){
            tmp[k++] = a[start++];
        }

        //将tmp中数字拷贝到a[p...r]
        for(i = 0;i<=r-p;++i){
            a[p+i] = tmp[i];
        }
    }

    /**
     * 合并(哨兵)
     *
     * @param arr
     * @param p
     * @param q
     * @param r
     */
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        // 第一个数组添加哨兵（最大值）
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        // 第二个数组添加哨兵（最大值）
        rightArr[r-q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            // 当左边数组到达哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }
}
