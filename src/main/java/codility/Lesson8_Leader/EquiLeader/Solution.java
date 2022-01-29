package codility.Lesson8_Leader.EquiLeader;

public class Solution {
    public int solution(int[] A){
        int accm[] = new int[A.length];
        int size = 0, value = 0, dominator = 0, cnt = 0, ans = 0;

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
                cnt++;
            }
            accm[i] = cnt;
        }

        int a, b;
        if(cnt > A.length/2) {//dominator 자격 요건 검증
            for(int i=0;i<accm.length-1;i++){
                a = accm[i];
                b = accm[accm.length-1]-accm[i];

                if(a > (i+1)/2 && b > ((accm.length-(i+1))/2)){
                    ans++;
                }
            }
        }else{
            ans = 0;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int test[] = {3,4,3,2,3,-1,3,3}; //4
//        int test[] = {3,4,3,2,3,-1,3}; //0
//        int test[] = {4,3,4,4,4,2}; //2
        int test[] = {3,4,3,4,3,4,3,3}; //4

        System.out.println(new Solution().solution(test));
    }
}
