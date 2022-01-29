package codility.Lesson8_Leader.Dominator;

public class Solution {
    public int solution(int[] A){
        int ans = -1;
        int size = 0, value = 0, dominator = 0, cnt = 0, idx = 0;

        for(int a:A){
            if(size == 0){
                value = a; size++;
            }else if(value != a){
                size--;
            }else if(value == a){
                size++;
            }
        }

        if(size>0)
            dominator = value;

        for(int i=0;i<A.length;i++){
            if(dominator == A[i]){
                idx = i;
                cnt++;
            }
        }

        if(cnt > A.length/2)//dominator 자격 요건 검증
            ans = idx;

        return ans;
    }

    public static void main(String[] args) {
        int test[] = {3,4,3,2,3,-1,3,3}; //7
//        int test[] = {4,5,6,5,6,6,8}; //-1
//        int test[] = {4,5,6,5,6,6,6,6,8}; //7
        System.out.println(new Solution().solution(test));
    }
}
