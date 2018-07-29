package com.sanjeev;

/**
 * Created by Sanjeev Guglani
 */
// 0/1 knapsack 2D Dynmaic programing
public class Knapsack {

    public static int maxPrice(int arr[][],int maxWeight,int beg){
        int profitWith =0;
        int profitWithout =0;
        if(beg==arr[0].length || maxWeight==0){
            return 0;
        }
        if(arr[0][beg]<=maxWeight) {

            profitWith = arr[1][beg] +maxPrice(arr,maxWeight-arr[0][beg],beg+1);
        }
        profitWithout =  maxPrice(arr,maxWeight,beg+1);
        return Math.max(profitWith,profitWithout);
    }

    public static void main(String[] args) {
        int arr[][]= new int[][]{{2,7,3,4},{5,20,20,10}};
        int maxWeight=11;
        System.out.println(maxPrice(arr,maxWeight,0));
    }
}
