package ch8.Q1_7;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    //==============================================尝试解题===========================================================
    // 方法一：记录所有0的行号、列号，将这些行和列都置零
    public void toZero(int[][] matrix){
        HashSet<Integer> row = new HashSet<Integer>();
        HashSet<Integer> col = new HashSet<Integer>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    if(!row.contains(i)){
                        row.add(i);
                    }
                    if(!col.contains(j)){
                        col.add(j);
                    }
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(row.contains(i)||col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]);
                if(j!=matrix[i].length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    //===========================================参考答案===============================================================
    //方法一【布尔数组】：使用布尔数组而不必使用哈希集
    public void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];  // boolean默认初始化为false

        // 记录值为0的元素所在行和列索引
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // 若行i或列j有元素为0，则将该行和列元素值为0
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(row[i]||col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }


    //==============================================程序入口============================================================
    public static void main(String[] args){
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution s = new Solution();
        s.toZero(a);
    }
}
