package codility.Lesson7_StacksAndQueues.Nesting;

import java.util.Stack;

public class Solution {
    public int solution(String S){
        char tmp;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            tmp = S.charAt(i);
            if(tmp == '('){
                stack.push(tmp);
            }else if(stack.isEmpty() || '(' != stack.pop())//닫는 경우
                return 0;
        }

        if(!stack.isEmpty()) return 0;//문자 검사가 다 끝났는데 스택이 비어있지 않은 경우우
       return 1;
    }

    public static void main(String[] args) {
//        String test = "(()(())())";//1
        String test = "())"; //0
//        String test = ")(";//0
//        String test = "{{{{";

        System.out.println(new Solution().solution(test));
    }
}
