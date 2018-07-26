package com.sanjeev;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sanjeev Guglani
 */
public class CoinChangeProblem {

    public static int coinChange(int n,int den[],int k,Map<String,Integer> map){
        if(n==0) return 1;
        if(k >= den.length) return 0;
        if(n<0) return 0;
        if(!map.containsKey(n+"|"+k)) {
            map.put(n + "|" + k, coinChange(n - den[k], den, k, map) + coinChange(n, den, k + 1, map));
        }
        return map.get(n+"|"+k);
    }

    public static void main(String[] args) {
        int den[] = {1,2,5};
        int n=10;
        long current = System.currentTimeMillis();
        int f=coinChange(n,den,0,new HashMap<String, Integer>());
        long after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));

       /* n=1000;
        current = System.currentTimeMillis();
        f=numberOfSteps(n);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));

        //DP
        n=10;
        int arr[]=new int[n+1];
        current = System.currentTimeMillis();
        f=numberOfStepsWithDP(n,arr);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));
        n=1000;
        arr =new int[n+1];
        current = System.currentTimeMillis();
        f=numberOfStepsWithDP(n,arr);
        after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));*/
    }


}
