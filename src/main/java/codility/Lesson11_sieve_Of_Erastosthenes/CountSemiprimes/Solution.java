package codility.Lesson11_sieve_Of_Erastosthenes.CountSemiprimes;

public class Solution {
    public int[] solution(int N, int[] P, int[] Q){
        int[] sieve = calSemiPrimeCnt(N, P, Q);
        int[] accmPrime = new int[N+1];

        int newI, sum = 0;
        for(int j=4;j<=N;j++){
            if(sieve[j] != 0){
                newI = j/sieve[j];
                if(sieve[newI] == 0)
                    sum++;
            }
            accmPrime[j] = sum;
        }

        int[] result = new int[P.length];
        for(int i=0;i<result.length;i++){
             result[i] = accmPrime[Q[i]] - accmPrime[P[i]-1];
        }
        return result;
    }

    private int[] calSemiPrimeCnt(int N, int[] P, int[] Q){
        int i= 2, k;
        int[] sieve = new int[N+1];

        while(i*i<=N){
            if(sieve[i] == 0){
                k = i*i;
                while(k<=N){
                    if(sieve[k]==0)
                        sieve[k] = i;
                    k += i;
                }
            }
            i+=1;
        };

        return sieve;

    }

    public static void main(String[] args) {
        int[] P = {1,4,16};
        int[] Q = {26,10,20};
        int[] result = new Solution().solution(26,P,Q);

        for (int r:result)
            System.out.println(r);
    }
}
