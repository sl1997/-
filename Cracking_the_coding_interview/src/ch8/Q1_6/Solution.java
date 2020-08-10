package ch8.Q1_6;

public class Solution {
    //==============================================尝试解题===========================================================
    //



    //===========================================参考答案===============================================================
    // 方法一【数组】：从外圈向内圈逐次进行替换
    public void rotate(int[][] matrix, int n){
        for(int layer=0;layer<n/2;++layer){  // 遍历层次（从外圈向内圈遍历）
            int first = layer;  // 当前圈的起始位置
            int last = n - layer -1;  // 当前圈的结束位置
            for(int i=first;i<last;i++){  // 遍历元素（遍历当前圈所有元素），只有一个元素时不旋转
                int offset = i - first;  // 当前圈的第几个
                int top = matrix[first][i];  // 上侧数据存入临时变量
                matrix[first][i] = matrix[last-offset][first];  // 左侧数据存向上侧
                matrix[last-offset][first] = matrix[last][last-offset];  // 下到左
                matrix[last][last-offset] = matrix[i][last]; // 右到下
                matrix[i][last] = top;

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


    //==============================================程序入口============================================================
    public static void main(String[] args){
        int[][] a = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Solution s = new Solution();
        s.printMatrix(a);
        s.rotate(a, 3);
//        s.rotate(a, 3);
//        System.out.println();
    }
}
