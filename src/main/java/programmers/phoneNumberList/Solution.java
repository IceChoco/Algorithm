package programmers.phoneNumberList;

import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phone_book){
        boolean answer = true;

        Arrays.sort(phone_book);

        String a,b;
        for(int i=0;i<phone_book.length-1;i++){
            a = phone_book[i];
            b = phone_book[i+1];

            if(b.startsWith(a))
                return false;
        }

        return answer;
    }

    public static void main(String[] args) {
//        String[] input = {"119", "97674223", "1195524421"};//false
//        String[] input = {"123","456","789"};//True
        String[] input = {"12","123","1235","567","88"};//false
        System.out.println(new Solution().solution(input));
    }
}
