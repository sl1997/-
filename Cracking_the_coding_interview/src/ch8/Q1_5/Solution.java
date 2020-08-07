package ch8.Q1_5;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    //==============================================尝试解题===========================================================

    public String compressString(String s){
        int count = 0, index = 0;
        char c = s.charAt(0);
        ArrayList<Character> chList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(c == s.charAt(i)){
                count++;
            }
            else{
                chList.add(c);
                chList.add((char)(count+'0'));  //字符转数字时会出现乱码，要使用这种方式
                c = s.charAt(i);
                count = 1;
            }
        }
        chList.add(c);
        chList.add((char)(count+'0'));  // 上面的判断语句导致最后一组字符没被记录（最后一组字符无法进入else循环）
        String result = Arrays.toString(chList.toArray());
        System.out.println(result.getClass().getName().toString());

//        if (result.length() >= s.length()){
//            return s;
//        }
        return result;
    }

    //===========================================参考答案===============================================================

    public String compressBad(String str){
        String mystr = "";
        char last = str.charAt(0);
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                count++;
            }
            else{
                mystr += last + "" + count;  // 注意这里的双引号将表示将变量类型转为字符串
                last = str.charAt(i);
                count = 1;
            }
        }
        return mystr + last + count;
    }

    //==============================================程序入口============================================================
    public static void main(String[] args){
        Solution s = new Solution();
        String s1 = "aabcccccaaa";
        String s2 = "abcdef";
        String result = s.compressBad(s2);
        System.out.println(result);
    }
}
