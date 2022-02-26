package codility.Lesson15_Caterpillar_method.CountDistinctSlices;

public class Solution {
    public int solution(int M, int[] A){
        int n = A.length;
        int[] visited = new int[M+1];
        int f = 0, cnt=0;

        for(int back = 0;back<n;back++){
            while (f<n && visited[A[f]] == 0){
                visited[A[f]]++;
                cnt += f-back + 1;
                if(cnt > 1000000000) return 1000000000;
                f++;
            }
            visited[A[back]]--;
        }

        return cnt;
    }

    public static void main(String[] args) {
        int M = 6;
        int[] A = {3,4,5,5,2};
        System.out.println(new Solution().solution(M,A));
    }
}
