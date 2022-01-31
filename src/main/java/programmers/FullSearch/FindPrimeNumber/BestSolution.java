package programmers.FullSearch.FindPrimeNumber;

import java.util.HashSet;

public class BestSolution {
    public int solution(String numbers){
        int answer = 0;
        HashSet<Integer> numSet = new HashSet<>();
        dfs(numbers, numSet, "");

        for(int n:numSet){
            //애초에 짝수는 거른다.
            if(n==2) answer++;
            if(n%2 != 0 && isPrime(n)) answer++;
        }

        return answer;
    }

    private void dfs(String numbers, HashSet<Integer> numSet, String num){
        int n = numbers.length();
        if(!num.equals("") && Integer.valueOf(num)>1)//소수는 1과 자기 자신만을 약수로 갖기 때문
            numSet.add(Integer.valueOf(num));
        for(int i=0;i<n;i++)
            dfs(numbers.substring(0,i)+numbers.substring(i+1,n), numSet, num+numbers.charAt(i));
    }

    private boolean isPrime(int n){
        int i=3;
        while(i*i<=n){
            if(n%i == 0) return false;
            i+=2;
        }
        return true;
    }

    public static void main(String[] args) {
        String n = "011";//2
//        String n = "17";//3
        System.out.println(new BestSolution().solution(n));
    }
}
