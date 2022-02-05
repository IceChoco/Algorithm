package codility.Lesson3_Time_Complexity.TapeEquilibrium;
/*
너무 어렵게 생각하지 말자
1. 구간합처럼 이진트리를 만든 후, N-1만큼 반복하면서 구간합끼리의 절대값 비교하기
  - 기대 시간복잡도: O(N*logN)
  - 실제 시간복잡도: N*N. 10만 X 10만 -> 100억 연산. 타임아웃
2. 첫번쨰 반복문으로 원소의 전체 합 구한 후, N-1만큼 반복하면서 원소의 값 하나씩 더하고 빼면서 비교하기
  - 실제 시간복잡도: O(N)
*/
public class Solution {
    private static int N, answer, section1, sum, section2;

    public int solution(int[] A){
        N = A.length;
        answer = Integer.MAX_VALUE;
        sum = 0;

        for(int i=0;i<N;i++){
            sum += A[i];
        }

        //최소 절대값 구하기
        section2 = sum;
        int diff;
        for(int i=1;i<N;i++){
            section1 += A[i-1];
            section2 -= A[i-1];
            diff = Math.abs(section1 - section2);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] test = {-1000,1000};
        //int[] test = {3,1,2,4,3};
        System.out.println(new Solution().solution(test));
    }

//    static void update(int index, int left, int right, int target, int value){
//        //범위 벗어난 경우
//        if(target < left || right < target)
//            return;
//        //도착한 경우
//        if(left == right){
//            tree[index] = value;
//            return;
//        }
//        //올바르게 가고 있는 경우
//        update(index * 2, left, (left+right)/2, target, value);
//        update(index * 2+1, (left+right)/2+1, right, target, value);
//        tree[index] = tree[index*2] + tree[index*2+1];
//    }
//
//    static int query(int index, int left, int right, int query_left, int query_right){
//        //범위 벗어난 경우
//        if(query_right < left || right < query_left)
//            return 0;//쿼리로 알고싶은 구간이 이 범위를 넘어선 경우
//        //도착한 경우
//        if(query_left <= left && right <= query_right)
//            return tree[index];
//        //올바르게 가고있는경우
//        return query(index*2, left, (left+right)/2, query_left, query_right)
//                + query(index*2+1, (left+right)/2+1, right, query_left,query_right);
//    }
}
