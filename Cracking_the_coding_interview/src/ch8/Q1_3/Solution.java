package ch8.Q1_3;

import java.util.HashMap;

public class Solution {
    //==============================================尝试解题===========================================================
    //方法一【数组】：使用两个数组分别存储字符串中每个字符出现的次数，然后对比两个数组中的值是否相同
    public boolean canTransform1(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        boolean result = true;
        int a[] = checkString(s1);
        int b[] = checkString(s2);
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                result = false;
            }
        }
        return result;
    }

    public int[] checkString(String s){
        int check[] = new int[256];
        for(int i=0;i<s.length();i++){
            check[s.charAt(i)]++;
        }
        return check;
    }

    //===========================================参考答案===============================================================
    // 方法一【排序字符串】：使用java.util.Arrays.sort方法对字符数组排序
    public boolean permutation(String s,String t){
        if(s.length()!=t.length())
            return false;
        return sort(s).equals(sort(t));  // 比较字符串
    }

    public String sort(String s){
        char[] content = s.toCharArray();  // 字符串转字符数组
        java.util.Arrays.sort(content);  //字符数组排序
        return new String(content);  //字符数组转字符串
    }

    // 方法二【数组】
    public boolean permutation2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        int[] letters = new int[256];

        char[] s_array = s.toCharArray();
        for(char c: s_array){
            letters[c]++;  // 对第一个字符串，出现一个字符在数组对应位置+1
        }

        for(int i=0;i<t.length();i++){
            int c = (int)t.charAt(i);
            if (--letters[c]<0){  // 对第二个字符串，出现一个字符在对应位置-1（原理在于字符总数相同）
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        String str1_1 = "abcdefg";
        String str1_2 = "gacbdfe";
        String str2_1 = "qweryy";
        String str2_2 = "qeyryw";

//        boolean result = s.canTransform1(str1_2, str1_1);
        boolean result = s.permutation(str2_2, str2_1);
        System.out.println(result);
    }
}
