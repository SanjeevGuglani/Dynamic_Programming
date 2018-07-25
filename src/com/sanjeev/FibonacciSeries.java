package com.sanjeev;

/**
 * Created by Sanjeev Guglani
 */
public class FibonacciSeries {

    public static long fibonacciSeries(int n){
        if(n==0 || n==1){
            return 1;
        }
        return fibonacciSeries(n-1) + fibonacciSeries(n-2);
    }

    public  static  long fibonacciSeriesWithDp(int n,long arr[]){
        if(n==0 || n==1){
            return 1;
        }
        if(arr[n]==0) {
            arr[n]=fibonacciSeriesWithDp(n - 1,arr) + fibonacciSeriesWithDp(n - 2,arr);
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n=5;
        long current = System.currentTimeMillis();
        long f=fibonacciSeries(n);
        long after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));
        n=45;
        current = System.currentTimeMillis();
        f=fibonacciSeries(n);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));

        //DP
        n=5;
        long arr[]=new long[n+1];
        current = System.currentTimeMillis();
        f=fibonacciSeriesWithDp(n,arr);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));
        n=45;
        arr =new long[n+1];
        current = System.currentTimeMillis();
        f=fibonacciSeriesWithDp(n,arr);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));
    }
}
