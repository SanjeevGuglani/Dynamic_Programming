package com.sanjeev;

/**
 * Created by Sanjeev Guglani
 */


// You are given a number.Your task is to minimize it
//(1) subtract with 1
//(2) DIVIDE IT BY 2. (IF n % 2 ==0)
//(3) DIVIDE IT BY 3. (IF n % 3 ==0)
//The first solution that comes to mind is to first check it is divisible by 3 then 2 then -1.In this way,We can becone greedy and know the steps
//But greedy wont work as PFB
// 10%2--> 5-1 ---> 4 %2 ---> 2 % 2 --> 1    (4 Steps)
    //But 10 -1 ---> 9 % 3 ---> 3 % 3 --> 1  (3 Steps)


public class MinimizeStepsToReachOne {

    public static int numberOfSteps(int n){
       int ans =0;
       if(n==1){
           return 0;
       }
       ans=1+numberOfSteps(n-1);
       if(n%2==0){
           ans = Math.min(ans,1+numberOfSteps(n/2));
       }
       if(n%3==0){
           ans = Math.min(ans,1+numberOfSteps(n/3));
       }
       return ans;
    }

    public static int numberOfStepsWithDP(int n,int arr[]){
        int ans =0;
        if(arr[n]==0) {
            if (n == 1) {
                return 0;
            }
            ans = 1 + numberOfStepsWithDP(n - 1,arr);
            if (n % 2 == 0) {
                ans = Math.min(ans, 1 + numberOfStepsWithDP(n / 2,arr));
            }
            if (n % 3 == 0) {
                ans = Math.min(ans, 1 + numberOfStepsWithDP(n / 3,arr));
            }
            arr[n]=ans;
        }
        return arr[n];
    }

    public static void main(String[] args) {
        int n=10;
        long current = System.currentTimeMillis();
        int f=numberOfSteps(n);
        long after = System.currentTimeMillis();
        System.out.println("res of "+n+" is "+f+" time "+(after-current));
        n=1000;
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
        System.out.println("res of "+n+" is "+f+" time "+(after-current));

    }
}
