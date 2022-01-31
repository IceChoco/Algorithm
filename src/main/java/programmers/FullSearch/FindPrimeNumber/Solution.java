package programmers.FullSearch.FindPrimeNumber;

import java.util.HashSet;

public class Solution {
    private static boolean[] visited;
    private static HashSet<Integer> numSet;
    private static int nowNum;

    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        numSet = new HashSet<Integer>();

        dfs(numbers, 1, visited, "");

        for(int n:numSet)
            if(isPrime(n))
                answer++;

        return answer;
    }

    private static void dfs(String numbers, int depth, boolean[] visited, String num){
        for(int i = 0;i<numbers.length();i++){
            if(!visited[i]){
                visited[i] = true;

                nowNum = Integer.valueOf(num+numbers.charAt(i));
                if(nowNum >1)
                    numSet.add(nowNum);

                dfs(numbers, depth+1,visited, num+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n){
        int i=2;//소수는 1과 자기 자신만을 약수로 갖기 때문
        while(i*i<=n){
            if(n%i == 0) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
//        String n = "011";//2
        String n = "17";//2
        System.out.println(new Solution().solution(n));
    }
}
