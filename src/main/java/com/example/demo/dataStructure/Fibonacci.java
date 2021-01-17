package com.example.demo.dataStructure;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
 * @author caomuya
 */
public class Fibonacci {

    private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    private static Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();

    public static int fibonacci(int n){
        if(n == 1 ){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(map.get(n)!=null){
            return map.get(n);
        }
        int fibonacci =fibonacci(n - 1) + fibonacci(n - 2);

        map.put(n,fibonacci);
        return fibonacci;
    }



//    编程实现求阶乘 n!
    public static int factorial(int n){

        if(n==1) return 1;
        if(n==2) return 2;
        if(map2.get(n)!=null){
            return map2.get(n);
        }
        int factorial = n * factorial(n - 1);
        map2.put(n,factorial);
        return factorial;
    }


    public static void main(String[] args) {
//        System.out.println( fibonacci(20));

        System.out.println( factorial(4));
    }
}
