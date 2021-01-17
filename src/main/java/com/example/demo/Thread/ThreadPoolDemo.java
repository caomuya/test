package com.example.demo.Thread;

import java.util.concurrent.*;

/**
 * @author caomuya
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {

//        System.out.println("---newFixedThreadPool----");
//        threadPoolTask(Executors.newFixedThreadPool(5));

//        System.out.println("---newSingleThreadExecutor----");
//        threadPoolTask(Executors.newSingleThreadExecutor());

//        System.out.println("---newCachedThreadPool----");
//        threadPoolTask(Executors.newCachedThreadPool());


        System.out.println("-----Custom Threae Pool----------");

        threadPoolTask(new ThreadPoolExecutor(
                1,
                3,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()));

    }

    private static void threadPoolTask(ExecutorService threadPool){
        try{
            for(int i=1; i<=10; i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

    }
}
