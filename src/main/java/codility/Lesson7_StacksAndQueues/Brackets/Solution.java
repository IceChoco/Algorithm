package codility.Lesson7_StacksAndQueues.Brackets;

import java.util.Stack;

public class Solution {
    public int solution(String S){
        char tmp, pair;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<S.length();i++){
            tmp = S.charAt(i);
            if(tmp == '{' || tmp == '(' || tmp == '['){
                stack.push(tmp);
            }else{//닫는 경우
                if(tmp == '}') pair = '{';
                else if(tmp == ')') pair = '(';
                else pair = '[';

                if(stack.isEmpty() || pair != stack.pop()) return 0;
            }
        }

        if(!stack.isEmpty()) return 0;//문자 검사가 다 끝났는데 스택이 비어있지 않은 경우우
       return 1;
    }

    public static void main(String[] args) {
//        String test = "{[()()]}";//1
//        String test = "([)()]";
//        String test = ")(";//0
        String test = "{{{{";

        System.out.println(new Solution().solution(test));
    }
}
