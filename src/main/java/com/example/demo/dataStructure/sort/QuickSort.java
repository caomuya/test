package com.example.demo.dataStructure.sort;

import java.util.PriorityQueue;

/**
 * 快排 O(nlogn)
 * 不稳定
 * @author caomuya
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{6,11,3,9,8};
        quickSort(a,a.length);
        for(int i = 0;i<a.length;i++){
            System.out.print(a[i]+"->");
        }

    }
    public static void quickSort(int[] a,int n){

        quickSortInternally(a,0,n-1);
    }

    private static void quickSortInternally(int[] a,int p, int r){
        if(p >= r){
            return;
        }
        int q = partition(a,p,r);

        quickSortInternally(a,p,q-1);
        quickSortInternally(a,q+1,r);

    }

    private static int partition(int[] a, int p, int r) {
        int pivot  = a[r];
        int i =p;
        for(int j = p; j<r;j++){
            if(a[j] < pivot){
                if(i == j){
                    ++i;
                }else {
                    int tmp = a[i];
                    a[i++]=a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        System.out.println("i ="+i);
        return i;
    }
}
