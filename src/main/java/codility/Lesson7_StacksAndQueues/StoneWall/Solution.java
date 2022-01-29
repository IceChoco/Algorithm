package codility.Lesson7_StacksAndQueues.StoneWall;

import java.util.Stack;

public class Solution {
    public int solution(int[] H){
        int cnt = 0;
        Stack<Integer> st = new Stack<>();

        st.push(H[0]);
        for(int i=1;i<H.length;i++){
            //1.원소비교
            while(!st.isEmpty()){
                if(H[i] >= st.peek()) //1) b >= a
                    break;
                else{ //2) a > b
                    st.pop(); cnt++;
                }
            }
            //2.자기 원소 더하기
            if(st.isEmpty() || st.peek()!=H[i])
                st.push(H[i]);
        }

        return cnt + st.size();
    }

    public static void main(String[] args) {
        int[] test = {8,8,5,7,9,8,7,4,8};
        System.out.println(new Solution().solution(test));
    }
}
