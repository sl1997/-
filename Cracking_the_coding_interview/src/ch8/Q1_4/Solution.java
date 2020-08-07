package ch8.Q1_4;

public class Solution {
    //==============================================尝试解题==========================================================
    // 方法一【字符数组】：遍历字符串，遇到空格则逐次存入“20%”中的字符，并使用变量index记录当前存入位置
    public String operateString(String s){
        char[] ch = new char[100];
        int index = 0;
        for(int i=0;i<s.length();i++){
            if((int)s.charAt(i) == 32){
                ch[index++] = '%';
                ch[index++] = '2';
                ch[index++] = '0';
            }
            else{
                ch[index++] = s.charAt(i);
            }
        }

        return new String(ch);
    }

    //=========================================参考答案=================================================================
    // 方法一【字符数组】
    public void replaceSpaces(char[] str, int length){
        int spaceCount = 0, newLength, i;
        for(i = 0;i<length;i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }
        newLength = length + spaceCount*2 - 1;  // 索引等于长度减一，不得已在这里表示索引
        for(i=length-1;i>=0;i--){
            if(str[i] == ' '){
                str[newLength--] = '0';
                str[newLength--] = '2';
                str[newLength--] = '%';
            }
            else{
                str[newLength--] = str[i];
            }
        }
        System.out.println(str);
    }

    // =============================================程序入口==========================================================
    public static void main(String[] args){
        Solution s = new Solution();
        String s1 = "Mr John Smith ";

        // 标准答案测试
        char[] ch = new char[100];
        int i = 0;
        for(char c:s1.toCharArray()){
            ch[i++] = c;
        }
        s.replaceSpaces(ch, 14);

//        // 尝试解题测试
//        String result = s.operateString(s1);
//        System.out.println(result);

    }
}
