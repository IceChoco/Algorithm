package programmers.DFS_BFS.Network;

public class DFS_Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int[][] computers, boolean[] visited, int from){
        visited[from] = true;
        for(int to=0;to<computers.length;to++){
            if(computers[from][to] == 1 && !visited[to]){
                dfs(computers, visited, to);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] test = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};//2
//        int[][] test = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};//1
//        int[][] test = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};//1
        int[][] test = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}};//1

        System.out.println(new Solution().solution(6,test));
    }
}
