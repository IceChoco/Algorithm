package codility.Lesson2_Arrays.CyclicRotation;

public class Solution {
    public int[] solution(int[] A, int K){
        int tmp[] = new int[A.length];
        int newPosition;
        for(int i=0;i<A.length;i++){
            newPosition = (i+K)%A.length;
            tmp[newPosition] = A[i];
        }
        return tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int test[] = {1,2,3,4};
        int result[] = s.solution(test, 4);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
