package ch8.Q1_1;

import java.util.HashSet;

public class Solution {
    //==========================================尝试解题===============================================================
    // 方法一【使用HashSet】：遍历字符串并存入哈希集，判断新的字符是否存在于哈希集中
    public boolean uniqueString1(String s){
        HashSet<Character> hashSet = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(hashSet.contains(s.charAt(i))){
                return false;
            }
            hashSet.add(s.charAt(i));
        }
        return true;
    }


    // 方法二【不使用额外的数据结构】：从第一个字符开始每个字符与后面所有的字符比较
    public boolean uniqueString2(String s){
        int len = s.length();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(s.charAt(i)==s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    //==============================================参考答案===========================================================
    // 方法一【使用boolean数组】：构造一个大小为256的字符数组，当字符第一次出现令其位置值为True，如果检查当前位置为True，说明已经出现过
    public boolean isUniqueChars2(String str){
        if(str.length()>256) return false;
        boolean char_set[] = new boolean[256];
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i);  //字符在计算机中是以ascii码的形式表示
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
    //方法二【使用位运算】:出现过的位置标位1，判定时，重复出现有（1&1=1）,第一次出现有（1&0=0）,据此判断结果，位运算适合对大量二值判断做标记
    public boolean isUniqueChars(String str){
        int checker = 0;
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i) - 'a';  // 当前字符在ascii码表中的编号
            if((checker & 1<<val)>0){  //当前字符存储到二进制数val中，与总存储二进制数check进行求且运算(只有相同位置都为1条件才为真)
                return false;
            }
            checker |= (1<<val);  // 将出现过字符在ascii码中的编号对应的二进制数位标记为1
        }
        return true;
    }


    //=========================================函数入口===================================================================
    public static void main(String[] args){
        Solution s = new Solution();
        String str1 = "absghetu";  // "True"
        String str2 = "afafasfaf";  // "False"
//        boolean result = s.uniqueString2(str1);
        boolean result = s.isUniqueChars(str2);
        System.out.println(result);
    }
}


