package ch8.Q1_5;

public class Solution {
    //==============================================尝试解题===========================================================
    //方法一【字符串】：自行尝试时未考虑出使用何种数据结构能够方便拼接
    public String compressString(String s){
        int count = 1;
        String str = "";
        char c = s.charAt(0);
        for(int i=1;i<s.length();i++){
            if(c == s.charAt(i)){
                count++;
            }
            else{
                str += c + "" + count;
                c = s.charAt(i);
                count = 1;
            }
        }
        str += c + "" + count;

        return str;
    }

    //===========================================参考答案===============================================================

    //方法一【字符串】：通过构造空字符串，在后面串联新的字符实现
    public String compressBad(String str){
        String mystr = "";
        char last = str.charAt(0);
        int count = 1;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==last){
                count++;
            }
            else{
                mystr += "" + last + count;  // 注意这里的双引号将表示将变量类型转为字符串,这里的count是可以超过9次的
                last = str.charAt(i);
                count = 1;
            }
        }
        return mystr + last + count;
    }

    //方法二【StringBuffer】：StringBuffer可以串联字符，且串联字符的速度比字符串拼接的速度要快（串联字符用StringBuffer替代String）
    String compressBetter(String str){
        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        int len = 0;
        for(int i=1;i<str.length();i++){
            if(last == str.charAt(i)){
                count++;
            }
            else{
                len += 1 + String.valueOf(count).length();  // 一个字母出现可能超过9次
                mystr.append(last);
                mystr.append(count);  // StringBuffer数组类型能够串联字符或字符串
                count = 1;
                last = str.charAt(i);
            }
        }
        len += 1 + String.valueOf(count).length();
        System.out.println(len);
        if(len>str.length()){
            return str;
        }
        return mystr.append(last).append(count).toString();
    }

    //方法三【字符数组】：先计算出压缩后字符长度，然后据此构造字符数组，插入字符数组时int==>String==>char[],然后循环插入字符数组
    String compressAlternate(String str){
        int size = countCompression(str);
        if(size > str.length()){
            return str;
        }
        int count = 1;
        char last = str.charAt(0);
        int index = 0;  // 每次将新的值插入字符数组时，记录数组末尾索引
        char ch[] = new char[size];  // 提前计算出字符数组长度了，就能够构造定长字符数组
        for(int i=1;i<str.length();i++){
            if(last == str.charAt(i)){
                count++;
            }
            else{
                index = addChar(ch, index, last, count);  // 根据输入索引index将last、count等内容插到数组ch后面，并返回末尾索引
                count = 1;
                last = str.charAt(i);
            }
        }
        index = addChar(ch, index, last, count);
        return new String(ch);
    }

    int addChar(char[] ch, int index, char last, int count){
        //将指定内容插入到字符数组指定位置
        ch[index++] = last;
        char chCount[] = String.valueOf(count).toCharArray();
        for(char c : chCount){
            ch[index++] = c;
        }
        return index;
    }

    int countCompression(String str){
        //计算压缩后字符数组长度
        char last = str.charAt(0);
        int count = 1;
        int compressLength = 0;
        for(int i=1;i<str.length();i++){
            if(str.charAt(i) == last){
                count++;
            }
            else{
                compressLength += 1 + String.valueOf(count).length();
                count = 1;
                last = str.charAt(i);
            }
        }
        compressLength += 1 + String.valueOf(count).length();
        return compressLength;
    }

    //==============================================程序入口============================================================
    public static void main(String[] args){
        Solution s = new Solution();
        String s1 = "aabcccccccccccccaaa";
        String s2 = "abcdef";
//        String result = s.compressBad(s2);
//        String result = s.compressString(s1);
//        String result = s.compressBetter(s2);
        String result = s.compressAlternate(s1);
        System.out.println(result);
    }
}
