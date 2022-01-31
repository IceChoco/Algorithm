package programmers.DFS_BFS.targetNumber;

public class Solution {
    private static boolean[] visited;
    private static int cnt;

    public int solution(int[] numbers, int target){
        cnt = 0;
        visited = new boolean[numbers.length];

        dfs(0, 0, numbers, target, true);
        dfs(0, 0, numbers, target, false);

        return cnt;
    }

    private void dfs(int idx, int sum, int[] numbers, int target, boolean plus){
        //마지막 인덱스인경우 검사
        if(idx == numbers.length){
            if(sum == target) cnt++;
            return;
        }

        //이전 방문 여부 체크 및 방문 표시
        if (visited[idx]) return;
        visited[idx] = true;

        //더하는 경우, 빼는 경우
        if(plus)
            sum += numbers[idx];
        else
            sum -= numbers[idx];

        //idx가 numbers.length-1인 경우 2개 중 1개만 호출
        if(idx != numbers.length -1)
            dfs(idx+1, sum, numbers, target, true);

        dfs(idx+1, sum, numbers, target, false);

        visited[idx] = false;
    }

    public static void main(String[] args) {
/*        int[] input = {1, 1, 1, 1, 1};//5
        int target = 3;*/

        int[] input = {4, 1, 2, 1};
        int target = 4;

        System.out.println(new Solution().solution(input, target));
    }
}
