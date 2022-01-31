package programmers.DFS_BFS.targetNumber;

/* [내 Solution과의 비교]
 * 1. visited 배열, boolean plus 매개변수, cnt 전역변수 불필요
 *  → dfs를 int 반환타입으로 바꿈
 *  → 길이가 완성되었을 때 바로 sum이랑 체크. 배열 밖의 idx 호출 불필요.
 *     → target num이랑 같으면 return 1, 다르면 return 0
 *
 * 2. sum에 numbers[idx] dfs 호출 시 매개변수로 바로 호출
 *  → return sum+numbers[idx] 매개변수로 호출 + sum-numbers[idx] 매개변수로 호출
 */
public class bestSolution {
    public int solution(int[] numbers, int target){
        int answer = 0;
        answer = dfs(0, numbers, 0, target);
        return answer;
    }

    private int dfs(int idx, int[] numbers, int sum, int target){
        if(idx == 0){
            if (sum==target) return 1;
            return 0;
        }

        return dfs(idx+1, numbers, sum+numbers[idx], target) + dfs(idx+1,numbers,sum-numbers[idx],target);
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 1, 1, 1};//5
        int target = 3;

//        int[] input = {4, 1, 2, 1};
//        int target = 4;

        System.out.println(new Solution().solution(input, target));
    }
}
