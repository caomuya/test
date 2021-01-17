package com.example.demo.dataStructure.sort;

/**
 * @author caomuya
 */
public class Sort {
    public static void main(String[] args) {
        Sort sort = new Sort();
//        sort.bubbledSort(new int[]{1,3,2,4,3,6},6);
        sort.selectedSort(new int[]{1,3,2,4,3,6},6);
    }

    /**
     * 冒泡排序 O(N^2)
     * @param a
     * @param n
     */
    public void bubbledSort(int[] a, int n){
        if(n<=1){
            return;
        }
        for(int i = 0; i<n; ++i){
            //提前退出冒泡循环的标志位
            boolean flag = false;
            for(int j = 0;j<n-i-1;++j){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }
    }

    /**
     * 插入排序 O(N^2)
     * @param a
     * @param n
     */
    public void insertSort(int[] a, int n){
        if(n<=1){
            return;
        }
        for(int i = 1; i<n; ++i){
           int value = a[i];
           int j = i-1;
           for(;j>0;--j){
               if(a[j]>value){
                   //搬移数据
                   a[j+1] = a[j];
               }
               else {
                   break;
               }
           }
           //插入数据
           a[j+1]=value;
        }
    }

    /**
     * 选择排序 O(N^2)
     * @param a
     * @param n
     */
    public void selectedSort(int[] a, int n){
        if(n<=1){
            return;
        }
        for(int i = 0; i<n-1; ++i){
            int min = i;
            for(int j=i+1; j<n;++j){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            int temp = a[i];
            a[i]=a[min];
            a[min] = temp;
        }
    }
}
