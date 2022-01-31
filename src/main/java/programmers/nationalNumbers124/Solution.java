package programmers.nationalNumbers124;

public class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        int[] oneTwoFourNation = {4,1,2};

        int remain;
        while(n > 0){
            remain = n%3;
            n/=3;

            if(remain == 0) n--;

            sb.insert(0,oneTwoFourNation[remain]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(10));
    }
}
