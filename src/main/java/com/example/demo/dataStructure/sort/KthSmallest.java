package com.example.demo.dataStructure.sort;

/**
 * @author caomuya
 */
public class KthSmallest {

    public static void main(String[] args) {
        int[] a = new int[]{6,11,3,9,8};
        int i1 = kthSmallest(a, 4);
        System.out.println(i1);
    }

    public static int kthSmallest(int[] arr,int k){
        if (arr == null || arr.length<k){
            return -1;
        }

        int partition = partition(arr, 0, arr.length - 1);
        while (partition+1 != k){
            if(partition+1 <k){
                partition=  partition(arr,partition+1,arr.length-1);
            }else{
                partition= partition(arr,0,partition-1);
            }
        }
            return arr[partition];

    }

    private static int partition(int[] arr, int p, int r) {
        int pivot  = arr[r];
        int i = p;
        for(int j=p;j<r;j++){
            if(arr[j]<=pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }



    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

