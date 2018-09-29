package com.sanjeev;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Sanjeev Guglani
 */
public class WaysOfRobot {
    public static int waysRobot(int row,int col,int i,int j,int cache[][]){
        if(i>=row || j>=col){
            return 0;
        }else if(i==(row-1) && j==(col-1)){
            return 1;
        }else {
           // System.out.println(i+" "+j+" "+cache[i][j]);
            if(cache[i][j]==-1){
                cache[i][j]=waysRobot(row,col,i+1,j,cache)+waysRobot(row,col,i,j+1,cache);
            }
            return cache[i][j];
        }
    }

    public static int waysRobot(int row,int col,int i,int j){
        if(i>=row || j>=col){
            return 0;
        }else if(i==(row-1) && j==(col-1)){
            return 1;
        }else {
           // System.out.println(i+" "+j+" ");
            return waysRobot(row,col,i+1,j)+waysRobot(row,col,i,j+1);
        }
    }
    public static void main (String[] args) {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for(int i=1;i<=test;i++){
            int row = cin.nextInt();
            int col = cin.nextInt();
            int cache[][]=new int[row][col];
            for(int j=0;j<row;j++){
                Arrays.fill(cache[j],-1);
            }
            System.out.println(waysRobot(row,col,0,0,cache));
        }
    }
}
