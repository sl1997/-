package ch8.Q1_8;

public class Solution {
    //==============================================尝试解题===========================================================


    //===========================================参考答案===============================================================
    public boolean isRotation(String s1,String s2){
        if(s1.length()==s2.length()){
            String s1s1 = s1+s1;
            if(isSubstring(s1s1, s2)){
                return true;
            }
        }
        return false;
    }


    public boolean isSubstring(String str, String substr){
        char ch = substr.charAt(0);
        boolean[] offset = new boolean[str.length()];
        for(int i=0;i<str.length();i++){
            if(ch==str.charAt(i)){
                offset[i] = true;
            }
        }
        for(int i=0;i<str.length();i++){
            if(offset[i]){
                if(i+substr.length()<=str.length()){
                    boolean flag = true;
                    for(int j=0;j<substr.length();j++){
                        if(str.charAt(i+j)!=substr.charAt(j)){
                            flag = false;
                        }
                    }
                    if(flag) return true;
                }
            }
        }
        return false;
    }


    //==============================================程序入口============================================================
    public static void main(String[] args){
        Solution s = new Solution();
        String str = "computer";
        String substr = "tercompu";
        System.out.println(s.isRotation(str, substr));
    }
}
